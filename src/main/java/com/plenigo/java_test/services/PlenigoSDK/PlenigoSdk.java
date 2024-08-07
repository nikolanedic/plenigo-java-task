package com.plenigo.java_test.services.PlenigoSDK;

import com.plenigo.java_test.services.PlenigoApiClient;
import com.plenigo.java_test.services.PlenigoSDK.Entities.EntityInterface;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlenigoSdk {

    private final PlenigoApiClient apiClient;

    public PlenigoSdk(PlenigoApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public <T extends EntityInterface> List<T> fetchEntities(Class<T> entityClass, int pageSize, Map<String, String> query, @Nullable String startingAfter) {
        if (startingAfter != null) {
            this.apiClient.startingAfter(startingAfter);
        }

        this.apiClient.size(pageSize);

        if (!query.isEmpty()) {
            this.apiClient.queryParameters(query);
        }


        return this.apiClient.get(entityClass);
    }

    public <T extends EntityInterface> List<T> fetchNEntities(Class<T> entityClass, int count) {
        List<T> entities =  new ArrayList<>();
        String startingAfter = "";
        List<T> batch;

        while (true) {
            if (startingAfter.isEmpty()) {
                batch = this.apiClient.size(100).get(entityClass);
            } else {
                batch = this.apiClient.size(100).startingAfter(startingAfter).get(entityClass);
            }

            if (batch.isEmpty() || batch.size() < 100 || entities.size() >= count) {
                break;
            }

            startingAfter = batch.getLast().getId();

            entities.addAll(batch);
        }

        return entities;
    }

    public <T extends EntityInterface> T fetchEntity(Class<T> entityClass, String entityId) {
        return this.apiClient.size(100).getOne(entityClass, entityId);
    }
}
