package com.newcheckstop.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends AppCompatActivity {

    private ListView mPhoneBookListView;
    private List<UserInfo> userInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        mPhoneBookListView = (ListView) findViewById(R.id.list_view);

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

        PhoneBookAdapter phoneBookAdapter = new PhoneBookAdapter(ListViewDemoActivity.this, userInfos);
        mPhoneBookListView.setAdapter(phoneBookAdapter);

        phoneBookAdapter.notifyDataSetChanged();

        mPhoneBookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                    phoneBookAdapter.refreshData(userInfos);
                }
                Toast.makeText(ListViewDemoActivity.this, userInfos.get(position).getUmserName()+"被我点击了",Toast.LENGTH_LONG).show();
            }
        });
    }
}