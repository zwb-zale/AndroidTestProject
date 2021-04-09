package com.newcheckstop.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemoActivity extends AppCompatActivity {

    private GridView mPhoneBookGridView;
    private List<UserInfo> userInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);

        mPhoneBookGridView = (GridView) findViewById(R.id.grid_view);

        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));
        userInfos.add(new UserInfo("电击方块",55));

        GridViewAdapter gridViewAdapter = new GridViewAdapter(GridViewDemoActivity.this, userInfos);
        mPhoneBookGridView.setAdapter(gridViewAdapter);

        gridViewAdapter.notifyDataSetChanged();

        mPhoneBookGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    //新建另外一批数据

                    //替换老数据

                    // 刷新listview，让它更新自己的视图
                    userInfos.clear();
                    Log.i(HomeActivity.TAG,String.valueOf(userInfos.size()));
                    for(int i = 0; i<30; i++){
                        userInfos.add(new UserInfo("我是"+i+"号",i));
                    }
                    Log.i(HomeActivity.TAG,String.valueOf(userInfos.size()));
                    gridViewAdapter.refreshData(userInfos);
                }
                Toast.makeText(GridViewDemoActivity.this, userInfos.get(position).getUmserName()+"被我点击了",Toast.LENGTH_LONG).show();
            }
        });
    }
}