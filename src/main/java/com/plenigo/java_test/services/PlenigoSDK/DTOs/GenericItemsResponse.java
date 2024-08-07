package com.plenigo.java_test.services.PlenigoSDK.DTOs;

import jakarta.annotation.Nullable;

import java.util.List;

public class GenericItemsResponse<T> {
    private @Nullable List<T> items;

    @Nullable
    public List<T> getItems() {
        return items;
    }

    public void setItems(@Nullable List<T> items) {
        this.items = items;
    }
}
