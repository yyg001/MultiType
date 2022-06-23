package com.example.multitype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.multitype.bean.AlllBean;
import com.example.multitype.bean.Title;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

public class TitleViewBinder extends ItemViewBinder<AlllBean, TitleViewBinder.TitleHolder> {

    private List<AlllBean> mList;

    public TitleViewBinder() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TitleHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.view1, viewGroup, false);
        return new TitleHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TitleHolder titleHolder, AlllBean title) {

        titleHolder.tv0.setText(title.getList1().get(0).getTitle());
        //填充数据渲染页面，比如setText setImage等工作
    }

    static class TitleHolder extends RecyclerView.ViewHolder {
        ImageView icon0;
        TextView tv0;

        TitleHolder(View itemView) {
            super(itemView);
            icon0 = (ImageView) itemView.findViewById(R.id.icon0);
            tv0 = (TextView) itemView.findViewById(R.id.tv0);

        }
    }
}
