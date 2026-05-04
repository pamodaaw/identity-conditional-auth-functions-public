/*
 * Copyright (c) 2026, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.conditional.auth.functions.http.util;

import org.apache.http.client.methods.HttpUriRequest;

/**
 * Extension of {@link AuthConfig} for authentication configurations that maintain a token cache
 * and are capable of obtaining a fresh credential on demand.
 */
public interface RefreshableAuthConfig extends AuthConfig {

    /**
     * Invalidates the currently cached credential and re-applies authentication to the request
     * using a freshly obtained token.
     * <p>
     * Implementations must evict the stale token from whatever cache they maintain before
     * delegating to their normal {@link #applyAuth} flow.
     *
     * @param request         the original {@link HttpUriRequest} to authenticate
     * @param authConfigModel the authentication configuration model
     * @return the authenticated {@link HttpUriRequest}, ready to be re-sent
     * @throws Exception if token retrieval or request decoration fails
     */
    HttpUriRequest refreshAuth(HttpUriRequest request, AuthConfigModel authConfigModel) throws Exception;
}
