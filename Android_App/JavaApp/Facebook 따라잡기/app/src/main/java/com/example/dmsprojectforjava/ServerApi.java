package com.example.dmsprojectforjava;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServerApi {

    @GET("/feed")
    Call<ServerRequest> getServer();

    @POST("/feed")
    Call<ServerResponse> createPost(@Body ServerResponse serverResponse);

    @DELETE("/feed/{feed_id}")
    Call<ServerResponse> getDelete(@Path("feed_id") String feed_id);

    @PATCH("/feed/{feed_id}")
    Call<ServerResponse> editPost(
            @Path("feed_id") String feed_id,
            @Body ServerResponse serverResponse
    );
}
