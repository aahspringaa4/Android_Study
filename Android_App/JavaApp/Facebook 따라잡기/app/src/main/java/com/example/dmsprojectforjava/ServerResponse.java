package com.example.dmsprojectforjava;

import androidx.annotation.NonNull;

public class ServerResponse { // 수신
    private String title;
    private String content;

    public ServerResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @NonNull

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
