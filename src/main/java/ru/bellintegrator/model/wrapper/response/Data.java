package ru.bellintegrator.model.wrapper.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data<T> {
    @JsonProperty("data")
    T data;

    public Data(T data) {
        this.data = data;
    }
}
