package com.example.dmsprojectforjava;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    public static String id;
    Context context;
    public static String editTitle;
    public static String editContent;

    private ArrayList<MainData> arrayList;
    public static boolean editStatus = false;

    public MainAdapter(ArrayList<MainData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item__view,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.tv_title.setText(arrayList.get(position).getTv_title());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        holder.tv_date.setText(arrayList.get(position).getTv_date());
        holder.tv_id.setText(arrayList.get(position).getTv_id());

        holder.itemView.setTag(position);

        holder.bt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 팝업 메뉴
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        // 수정 클릭
                        if (item.getItemId() == R.id.action_edit) {
                            // 데이터 저장
                            editTitle= arrayList.get(position).getTv_title();
                            editContent = arrayList.get(position).getTv_content();


                            editStatus = true;
                            id = arrayList.get(position).getTv_id();

                            Intent intent = new Intent(v.getContext(), AddActivity.class);
                            v.getContext().startActivity(intent);

                        } // 삭제 클릭
                        else if (item.getItemId() == R.id.action_delete) {

                            // 뷰 (서버 게시물 아이디)
                            id = arrayList.get(position).getTv_id();
                            MainActivity.deletePost(id);
                            remove(holder.getAdapterPosition());

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        //holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }
    public void remove(int position) {
        try { // 예외사항이 생겨도 강제실행
            arrayList.remove(position);
            notifyItemRemoved(position); // 새로고침
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_date;
        protected TextView tv_title;
        protected TextView tv_content;
        protected Button bt_more;
        protected TextView tv_id;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            this.tv_title= (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            this.bt_more = (Button) itemView.findViewById(R.id.bt_more);
            this.tv_id = (TextView) itemView.findViewById(R.id.tv_id);
        }
    }
}