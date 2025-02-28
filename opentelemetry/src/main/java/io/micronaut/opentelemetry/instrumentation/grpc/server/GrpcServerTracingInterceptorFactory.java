/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.opentelemetry.instrumentation.grpc.server;

import io.grpc.ServerInterceptor;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

/**
 * Factory that builds the Tracing interceptors.
 *
 * @author Alexey Zhokhov
 * @since 1.0
 */
@Factory
public class GrpcServerTracingInterceptorFactory {

    /**
     * The server interceptor.
     *
     * @param configuration The configuration
     * @return The server interceptor
     */
    @Nonnull
    @Requires(beans = GrpcServerTracingInterceptorConfiguration.class)
    @Singleton
    @Bean
    protected ServerInterceptor serverTracingInterceptor(@Nonnull GrpcServerTracingInterceptorConfiguration configuration) {
        return configuration.getBuilder().build().newServerInterceptor();
    }

}
