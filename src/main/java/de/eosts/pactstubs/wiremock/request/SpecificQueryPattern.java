/**
 *
 *    Copyright 2020 EOS Technology Solutions GmbH
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package de.eosts.pactstubs.wiremock.request;

import au.com.dius.pact.core.model.Request;
import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;

import java.util.Map;

public class SpecificQueryPattern implements Pact2WireMockRequestPattern {

    private final Map<String, String> specificQueryParams;

    public SpecificQueryPattern(Map<String, String> specificQueryParams) {
        this.specificQueryParams = specificQueryParams;
    }

    @Override
    public void accept(Request pactRequest, RequestPatternBuilder requestPatternBuilder) {
        if (!specificQueryParams.isEmpty()) {
            specificQueryParams.forEach((queryKey, queryValue) -> requestPatternBuilder.withQueryParam(queryKey, new EqualToPattern(queryValue)));
        }
    }
}