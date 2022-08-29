/*
 * Copyright © 2020 Cask Data, Inc.
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

import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.plugin.common.ReferencePluginConfig;

import javax.annotation.Nullable;

/**
 * Provides base configuration for accessing Hubspot API.
 */
public class BaseHubspotConfig extends ReferencePluginConfig {

  public static final String API_SERVER_URL = "apiServerUrl";
  public static final String OBJECT_TYPE = "objectType";
  public static final String ACCESS_TOKEN = "accessToken";
  public static final String DEFAULT_API_SERVER_URL = "https://api.hubapi.com";

  @Name(API_SERVER_URL)
  @Description("Api Server Url. Not visible, by default null, can be redefined")
  @Macro
  @Nullable
  public String apiServerUrl;
  @Name(OBJECT_TYPE)
  @Description("Name of object to pull from Hubspot.")
  @Macro
  public String objectType;
  @Name(ACCESS_TOKEN)
  @Description("OAuth2 Access Token")
  @Macro
  public String accessToken;

  public BaseHubspotConfig(String referenceName) {
    super(referenceName);
  }

  /**
   * Constructor for BaseHubspotConfig object.
   * @param referenceName the reference name
   * @param apiServerUrl the api server url of hub spot
   * @param objectType the object type
   * @param accessToken the access token generated from private apps
   */
  public BaseHubspotConfig(String referenceName,
                           String apiServerUrl,
                           String objectType,
                           String accessToken) {
    super(referenceName);
    this.apiServerUrl = apiServerUrl;
    this.objectType = objectType;
    this.accessToken = accessToken;
  }

  public ObjectType getObjectType() {
    return ObjectType.fromString(objectType);
  }

  /**
   * Returns the string as an api server url.
   * @return the string as an api server url
   */
  public String getApiServerUrl() {
    String apiServerUrl = BaseHubspotConfig.DEFAULT_API_SERVER_URL;
    if (this.apiServerUrl != null &&
      !this.apiServerUrl.isEmpty()) {
      apiServerUrl = this.apiServerUrl;
    }
    return apiServerUrl;
  }
}
