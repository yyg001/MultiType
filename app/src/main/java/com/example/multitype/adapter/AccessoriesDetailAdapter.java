package com.example.multitype.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multitype.R;
import com.example.multitype.bean.Title2;

import java.util.List;

public class AccessoriesDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mInflater;
    private List<Title2> mData;

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv0;

        public MyViewHolder(View convertView) {
            super(convertView);
            tv0 = convertView.findViewById(R.id.tv0);
        }
    }




    public AccessoriesDetailAdapter(Context context, List<Title2> datas) {
        this.mData = datas;
        mInflater = LayoutInflater.from(context);

    }

    public void setDataSource(List<Title2> listData) {
        mData = listData;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout2, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        AccessoriesDetailAdapter.MyViewHolder myHeaderViewHolder = (AccessoriesDetailAdapter.MyViewHolder) holder;
        if (mData != null && mData.size() > 0) {
            myHeaderViewHolder.tv0.setText(mData.get(position).getTitle());
        }


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}