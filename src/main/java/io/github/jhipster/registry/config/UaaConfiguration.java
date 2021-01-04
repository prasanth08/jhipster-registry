/*
 * Copyright 2015-2021 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see https://www.jhipster.tech/
 * for more information.
 *
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
 */
package io.github.jhipster.registry.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import static io.github.jhipster.registry.config.Constants.PROFILE_UAA;

@Configuration
@Profile(PROFILE_UAA)
public class UaaConfiguration {

    public static final String CLIENT_REGISTRATION_ID = "uaa";

    private final ClientRegistrationRepository clientRegistrationRepository;
    private final RestTemplateBuilder restTemplateBuilder;

    public UaaConfiguration(ClientRegistrationRepository clientRegistrationRepository, RestTemplateBuilder restTemplateBuilder) {
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Bean
    @LoadBalanced
    public RestTemplate uaaRestTemplate() {
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(CLIENT_REGISTRATION_ID);
        if (null == clientRegistration) {
            throw new IllegalArgumentException("Invalid Client Registration with Id: " + CLIENT_REGISTRATION_ID);
        }

        return restTemplateBuilder
            .messageConverters(
                new FormHttpMessageConverter(),
                new OAuth2AccessTokenResponseHttpMessageConverter())
            .errorHandler(new OAuth2ErrorResponseErrorHandler())
            .basicAuthentication(clientRegistration.getClientId(), clientRegistration.getClientSecret())
            .build();
    }
}
