package com.example.ioeyes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import java.util.ArrayList;

public class MainActivity<MainData> extends AppCompatActivity {

    private ArrayList<MainData> arrayList; // MaindData를 담은 배열 리스트인 arrayList를 선언
    private MainAdapter mainAdapter; // 인스턴스 mainAdapter를 선언
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; // 레이아웃 관리자 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv_help = findViewById(R.id.help);
////        tv_help.setMovementMethod(new ScrollingMovementMethod());
////        recyclerView = (RecyclerView) findViewById(R.id.rv);
//        linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager); // recyclerView를 통해 리사이클러뷰를 지정
//
//        arrayList = new ArrayList<>();
//
//        mainAdapter = new MainAdapter(arrayList); // 인스턴스 생성
//        recyclerView.setAdapter(mainAdapter); // 어댑터를 mainAdapter로 설정
//
//        itemadd();
    }
//    private void itemadd() {
//        MainData mainData;
//
//        mainData = new MainData("0.1");
//        arrayList.add(mainData);
//
//        mainAdapter.notifyDataSetChanged(); // 새로고침
//    }
}