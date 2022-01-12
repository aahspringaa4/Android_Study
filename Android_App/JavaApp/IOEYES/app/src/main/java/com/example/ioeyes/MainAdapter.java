package com.example.ioeyes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainAdapter<MainData> extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> arraylist; // MainData를 리스트배열 arraylist에 넣음

    public MainAdapter(ArrayList<MainData> arraylist) { // 생성자
        this.arraylist = arraylist;
    }

    @NonNull // null을 허용하지 않는다.
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ViewHolder와 레이아웃 파일을 연결해주는 역할

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sight_item_view, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view); // View를 가져온다.

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MainAdapter.CustomViewHolder holder, int position) {

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return (null != arraylist ? arraylist.size() : 0);
    } // arraylist가 null이 아닐 경우 arraylist.size() 반환


//    public void remove(int position) {
//        try { // 예외사항이 생겨도 강제실행
//            arraylist.remove(position);
//            notifyItemRemoved(position); // 새로고침
//        } catch (IndexOutOfBoundsException ex) {
//            ex.printStackTrace();
//        }
//    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView sight;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sight = (TextView) itemView.findViewById(R.id.sight);
        }
    }
}