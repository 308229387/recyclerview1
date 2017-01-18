package com.example.songyongmeng.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private GridLayoutManager mGridManager;
    private MyAdapter mAdapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mGridManager = new GridLayoutManager(this,9);
        mRecyclerView.setLayoutManager(mGridManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        list = getList();
        //创建并设置Adapter
        mAdapter = new MyAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MyAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_LONG).show();
            }
        });


    }

    //获取List方法
    private List<String> getList() {
        List<String> list = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; ++i) {
            list.add("" + (char) i);
        }
        return list;
    }

}
