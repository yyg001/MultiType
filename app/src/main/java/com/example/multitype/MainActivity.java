package com.example.multitype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.multitype.bean.AlllBean;
import com.example.multitype.bean.Title;
import com.example.multitype.bean.Title2;
import com.example.multitype.bean.Title3;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.Linker;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;
    AlllBean bean = new AlllBean();
    Button button;
    private MultiTypeAdapter multiTypeAdapter;
    private List<Title> list = new ArrayList<>();
    private List<Title2> list2 = new ArrayList<>();
    private List<Title3> list3 = new ArrayList<>();


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list2.clear();
                list2.add(new Title2("王者荣耀2", "22"));
                list2.add(new Title2("吃鸡2", "22"));
                list2.add(new Title2("穿越火线2", "22"));
                list2.add(new Title2("小猫捕鱼2", "22"));
                list2.add(new Title2("刺激战场2", "22"));
                list2.add(new Title2("战地之王2", "22"));
                bean.setList2(list2);

                Items items = new Items();

                for (int i = 0; i < 3; i++) {
                    items.add(bean);
                }

                multiTypeAdapter.setItems(items);
                multiTypeAdapter.notifyDataSetChanged();

            }
        });

        list = new ArrayList<>();
        recycleView = findViewById(R.id.recycleView);

        recycleView.setLayoutManager(new LinearLayoutManager(this));
        multiTypeAdapter = new MultiTypeAdapter();
        multiTypeAdapter.register(AlllBean.class).to(new TitleViewBinder(),
                new TitleViewBinder3(),
                new TitleViewBinder2()).withLinker(new Linker<AlllBean>() {
            @Override
            public int index(int position, @NonNull AlllBean alllBean) {
                return position;
            }
        });

        recycleView.setAdapter(multiTypeAdapter);

        list.add(new Title("测试1", "55"));
        list.add(new Title("测试2", "55"));
        list.add(new Title("测试3", "55"));
        list.add(new Title("测试4", "55"));
        list.add(new Title("测试5", "55"));
        list.add(new Title("测试6", "55"));
        bean.setList1(list);

        list2.add(new Title2("王者荣耀", "22"));
        list2.add(new Title2("吃鸡", "22"));
        list2.add(new Title2("穿越火线", "22"));
        list2.add(new Title2("小猫捕鱼", "22"));
        list2.add(new Title2("刺激战场", "22"));
        list2.add(new Title2("战地之王", "22"));
        bean.setList2(list2);

        list3.add(new Title3("热门应用"));
        bean.setList3(list3);

        Items items = new Items();

        for (int i = 0; i < 3; i++) {//几种类型数量就是几
            items.add(bean);
        }

        multiTypeAdapter.setItems(items);
        multiTypeAdapter.notifyDataSetChanged();

    }
}