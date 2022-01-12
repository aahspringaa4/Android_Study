package com.example.firebasepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true); // 리사이 클러뷰 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // User 객체를 담을 ArrayList

        database = FirebaseDatabase.getInstance(); // 파이어 베이스 데이터 베이스 연동
        databaseReference = database.getReference("User"); // DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어 베이스의 데이터를 받아 오는 곳
                arrayList.clear(); // 기존 배열 리스트가 존재 하지 않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){ // 반복문으로 List 데이터 값 추출
                    User user = snapshot.getValue(User.class); // 만들어 줬던 User 객체에 데이터를 담는다.
                    arrayList.add(user); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰에 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 데이터 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 데이터 베이스를 가져 오던중 오류 발생시
                    Log.d("MainActivity", String.valueOf(databaseError.toException())); // 에러 발생시 에처문 출력
                Toast.makeText(MainActivity.this, "데이터 영입에 실패 하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter); // 리사이 클러뷰에 어뎁터 연결
    }
}