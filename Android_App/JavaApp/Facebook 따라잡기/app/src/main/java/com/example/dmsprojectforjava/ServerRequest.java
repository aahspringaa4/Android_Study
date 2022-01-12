package com.example.dmsprojectforjava;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ServerRequest {
    private List<JsonObject> feed;

    public List<JsonObject> getFeed() {
        return feed;
    }
}