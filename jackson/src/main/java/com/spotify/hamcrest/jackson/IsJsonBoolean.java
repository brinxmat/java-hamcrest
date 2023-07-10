/*-
 * -\-\-
 * hamcrest-jackson
 * --
 * Copyright (C) 2016 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.hamcrest.jackson;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Objects;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class IsJsonBoolean extends AbstractJsonNodeMatcher<BooleanNode> {

  private final Matcher<? super Boolean> booleanMatcher;

  private IsJsonBoolean(Matcher<? super Boolean> booleanMatcher) {
    super(JsonNodeType.BOOLEAN);
    this.booleanMatcher = Objects.requireNonNull(booleanMatcher);
  }

  public static Matcher<JsonNode> jsonBoolean() {
    return new IsJsonBoolean(is(anything()));
  }

  public static Matcher<JsonNode> jsonBoolean(boolean bool) {
    return new IsJsonBoolean(is(bool));
  }

  public static Matcher<JsonNode> jsonBoolean(Matcher<? super Boolean> booleanMatcher) {
    return new IsJsonBoolean(booleanMatcher);
  }

  public static Matcher<JsonNode> jsonBoolean(final BooleanNode value) {
    return jsonBoolean(value.booleanValue());
  }

  @Override
  protected boolean matchesNode(BooleanNode node, Description mismatchDescription) {
    final boolean value = node.asBoolean();

    if (booleanMatcher.matches(value)) {
      return true;
    } else {
      mismatchDescription.appendText("was a boolean node with value that ");
      booleanMatcher.describeMismatch(value, mismatchDescription);
      return false;
    }
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("a boolean node with value that ").appendDescriptionOf(booleanMatcher);
  }
}
