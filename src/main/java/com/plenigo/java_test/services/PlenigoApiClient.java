package com.plenigo.java_test.services;

import com.plenigo.java_test.config.PlenigoConfig;
import com.plenigo.java_test.services.PlenigoSDK.DTOs.GenericItemsResponse;
import com.plenigo.java_test.services.PlenigoSDK.Entities.EntityInterface;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.util.annotation.NonNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlenigoApiClient {
    private final PlenigoConfig plenigoConfig;

    private int size = 10;
    private String startingAfter = "";
    private Map<String, String> queryParameters = new HashMap<>();

    public PlenigoApiClient(PlenigoConfig plenigoConfig) {
        this.plenigoConfig = plenigoConfig;
    }

    public <T extends EntityInterface> List<T> get(Class<T> entityClass) {
        WebClient.Builder webClientBuilder = WebClient.builder();

        // Since we're using a generic type, the deserializer lacks the information needed to correctly deserialize the JSON.
        // To address this, we dynamically provide the exact concrete class type at runtime.
        ParameterizedTypeReference<GenericItemsResponse<T>> typeRef = new ParameterizedTypeReference<GenericItemsResponse<T>>() {
            @Override
            public @NonNull Type getType() {
                return new DynamicParameterizedType(GenericItemsResponse.class, new Type[]{entityClass});
            }
        };

        return webClientBuilder.baseUrl(this.plenigoConfig.getApiUrl()).build().get()
            .uri(this.buildUri(entityClass, HttpMethod.GET, null))
            .header("X-plenigo-token", this.plenigoConfig.getApiKey())
            .retrieve()
            .bodyToMono(typeRef)
            .mapNotNull(GenericItemsResponse::getItems)
            .block();
    }

    public <T extends EntityInterface> T getOne(Class<T> entityClass, String entityId) {
        WebClient.Builder webClientBuilder = WebClient.builder();

        return webClientBuilder.baseUrl(this.plenigoConfig.getApiUrl()).build().get()
            .uri(this.buildUri(entityClass, HttpMethod.GET, entityId))
            .header("X-plenigo-token", this.plenigoConfig.getApiKey())
            .retrieve()
            .bodyToMono(entityClass)
            .block();
    }

    public <T extends EntityInterface> String buildUri(Class<T> entityClass, HttpMethod method, String entityId) {
        UriBuilder uriBuilder = UriComponentsBuilder.newInstance();
        String path = "/"+entityClass.getSimpleName().toLowerCase()+'s';

        if (entityId != null && !entityId.isEmpty()) {
            path += "/" + entityId;
        }

        if (!this.queryParameters.isEmpty()) {
            for (Map.Entry<String, String> entry : this.queryParameters.entrySet()) {
                String key = entry.getKey();
                String value =entry.getValue();
                uriBuilder.queryParam(key, value);
            }
        }

        uriBuilder.path(path);

        if (method == HttpMethod.GET) {
            uriBuilder.queryParam("size", this.size);

            if (this.startingAfter.isEmpty()) {
                uriBuilder.queryParam("startingAfter", this.startingAfter);
            }
        }

        return uriBuilder.toUriString();
    }

    public PlenigoApiClient size(int size) {
        this.size = size;

        return this;
    }

    public PlenigoApiClient startingAfter(String startingAfter) {
        this.startingAfter = startingAfter;

        return this;
    }

    public PlenigoApiClient queryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;

        return this;
    }

    /**
     * Workaround to resolve entity type during runtime
     */
    private static class DynamicParameterizedType implements ParameterizedType {

        private final Class<?> rawType;
        private final Type[] typeArguments;

        public DynamicParameterizedType(Class<?> rawType, Type[] typeArguments) {
            this.rawType = rawType;
            this.typeArguments = typeArguments;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return typeArguments;
        }

        @Override
        public Type getRawType() {
            return rawType;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }
}
