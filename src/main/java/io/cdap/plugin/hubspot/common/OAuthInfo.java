/*
 * Copyright © 2022 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.cdap.plugin.hubspot.common;

/**
 * A class for storing the OAuth information returned by the {@code ${oauth}} macro function.
 */
public final class OAuthInfo {

  private final String accessToken;
  private final String instanceURL;

  public OAuthInfo(String accessToken, String instanceURL) {
    this.accessToken = accessToken;
    this.instanceURL = instanceURL;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getInstanceURL() {
    return instanceURL;
  }
}