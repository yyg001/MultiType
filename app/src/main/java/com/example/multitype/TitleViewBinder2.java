package com.example.multitype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.multitype.adapter.AccessoriesDetailAdapter;
import com.example.multitype.bean.AlllBean;
import com.example.multitype.bean.Title;
import com.example.multitype.bean.Title2;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

public class TitleViewBinder2 extends ItemViewBinder<AlllBean, TitleViewBinder2.TitleHolder> {
    private Context mContext;
    private List<AlllBean> mList;

    public TitleViewBinder2() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TitleHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.view2, viewGroup, false);
        this.mContext = view.getContext();
        return new TitleHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TitleHolder titleHolder, AlllBean title) {

        titleHolder.tv0.setText(title.getList2().get(0).getTitle());
        titleHolder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        AccessoriesDetailAdapter accessoriesDetailAdapter =new AccessoriesDetailAdapter(mContext,title.getList2());
        titleHolder.recyclerView.setAdapter(accessoriesDetailAdapter);

    }

    static class TitleHolder extends RecyclerView.ViewHolder {
        ImageView icon0;
        TextView tv0;
        RecyclerView recyclerView;

        TitleHolder(View itemView) {
            super(itemView);

            tv0 = (TextView) itemView.findViewById(R.id.tv0);
            recyclerView = itemView.findViewById(R.id.recyclerView);

        }
    }
}
