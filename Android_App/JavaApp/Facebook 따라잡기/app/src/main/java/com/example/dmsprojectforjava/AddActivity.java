package com.example.dmsprojectforjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {


    ImageButton bt_back;
    Button PostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        if(MainAdapter.editStatus == true){
            editPost("data", "topic", "subject");
        }

        ServerApi serverApi;

        bt_back = (ImageButton) findViewById(R.id.bt_back);
        PostButton = (Button) findViewById(R.id.PostButton);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               finish();
            }
        });

        PostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerApi ServerApi = ApiProvider.getInstance().create(ServerApi.class);
                ServerResponse post = new ServerResponse("title", "content");
                Call<ServerResponse> call = ServerApi.createPost(post);

                call.enqueue(new Callback<ServerResponse>() {
                    @Override
                    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                       finish();
                        Log.d("결과", "성공");
                    }

                    @Override
                    public void onFailure(Call<ServerResponse> call, Throwable t) {
                       Log.d("실패", "실패");
                    }
                });
            }
        });
    }

    public void editPost(String data, String title, String content) {
        ServerApi ServerApi = ApiProvider.getInstance().create(ServerApi.class);
        ServerResponse post = new ServerResponse(title, content);
        Call<ServerResponse> call = ServerApi.editPost(data, post);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                finish();
            }
            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

            }
        });
    }
}