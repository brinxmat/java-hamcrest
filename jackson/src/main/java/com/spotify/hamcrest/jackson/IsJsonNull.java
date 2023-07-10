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
import com.fasterxml.jackson.databind.node.NullNode;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class IsJsonNull extends AbstractJsonNodeMatcher<NullNode> {
  private static final IsJsonNull INSTANCE = new IsJsonNull();

  private IsJsonNull() {
    super(JsonNodeType.NULL);
  }

  public static Matcher<JsonNode> jsonNull() {
    return INSTANCE;
  }

  @SuppressWarnings("unused")
  public static Matcher<JsonNode> jsonNull(final NullNode value) {
    return jsonNull();
  }

  @Override
  protected boolean matchesNode(NullNode node, Description mismatchDescription) {
    return true;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("a null node");
  }
}
