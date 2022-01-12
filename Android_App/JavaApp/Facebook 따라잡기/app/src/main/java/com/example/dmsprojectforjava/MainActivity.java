package com.example.dmsprojectforjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList = new ArrayList<>();
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArraySet<String> SpinnerList;
    private ServerRequest requestValue;
    private ImageButton button;
    private ServerApi serverApi;

    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        mainAdapter = new MainAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(mainAdapter);

        button = (ImageButton) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

    }

    @NotNull
    private void StartSetPost(ServerRequest serverRequest){
        Log.d("왜 안될까1", "되나");
        @NotNull
        int totalElements = serverRequest.getFeed().size();
        Log.d("왜 안될까", "되나");
        for(int i = 0; i < totalElements; i++) {
            JsonObject jsonObject = serverRequest.getFeed().get(i);

            String tv_id = jsonObject.get("id").toString();
            String tv_topic = jsonObject.get("topic").toString();
            String tv_subject = jsonObject.get("subject").toString();
            String tv_date = jsonObject.get("date").toString();

            tv_topic = tv_topic.replaceAll("\"", "");
            tv_subject = tv_subject.replaceAll("\"", "");
            tv_date = tv_date.replaceAll("\\\\n", "\n");
            tv_id = tv_id.replaceAll("\\\\","\n");

            MainData mainData = new MainData(tv_topic, tv_subject, tv_id, tv_date);
            arrayList.add(mainData);

            mainAdapter.notifyDataSetChanged();
        }
    }

    @NonNull
    public static void deletePost(String data) {
        ServerApi ServerApi = ApiProvider.getInstance().create(ServerApi.class);
        ServerApi.getDelete(data).enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, @NotNull Response<ServerResponse> response) {
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
            }
        });
    }

    @NonNull
    @Override
    protected void onResume() {
        super.onResume();

        arrayList.clear();
        mainAdapter.notifyDataSetChanged();

        ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
        Call<ServerRequest> call = serverApi.getServer();
        call.enqueue(new Callback<ServerRequest>() {
            @Override
            public void onResponse(Call<ServerRequest> call, @NotNull Response<ServerRequest> response) {
                Log.d("결과2", "성공2");
                requestValue = response.body();
                StartSetPost(requestValue);
            }

            @Override
            public void onFailure(Call<ServerRequest> call, Throwable t) {
                Log.d("결과3", "성공3");
            }
        });


    }


}