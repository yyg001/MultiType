package com.example.multitype;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.multitype.bean.AlllBean;
import com.example.multitype.bean.Title2;
import com.example.multitype.bean.Title3;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

public class TitleViewBinder3 extends ItemViewBinder<AlllBean, TitleViewBinder3.TitleHolder> {

    private List<AlllBean> mList;

    public TitleViewBinder3() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TitleHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.view3, viewGroup, false);
        return new TitleHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TitleHolder titleHolder, AlllBean title) {

        titleHolder.tv0.setText(title.getList3().get(0).getTitle());
        titleHolder.tv0.setTextSize(20);
        titleHolder.tv0.setTextColor(R.color.black);
        //填充数据渲染页面，比如setText setImage等工作
    }

    static class TitleHolder extends RecyclerView.ViewHolder {
        TextView tv0;

        TitleHolder(View itemView) {
            super(itemView);

            tv0 = (TextView) itemView.findViewById(R.id.tv0);

        }
    }
}
