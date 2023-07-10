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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class IsJsonMissing extends AbstractJsonNodeMatcher<MissingNode> {
  private static final IsJsonMissing INSTANCE = new IsJsonMissing();

  protected IsJsonMissing() {
    super(JsonNodeType.MISSING);
  }

  public static Matcher<JsonNode> jsonMissing() {
    return INSTANCE;
  }

  @SuppressWarnings("unused")
  public static Matcher<JsonNode> jsonMissing(final MissingNode value) {
    return jsonMissing();
  }

  @Override
  protected boolean matchesNode(MissingNode node, Description mismatchDescription) {
    return true;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("a missing node");
  }
}
