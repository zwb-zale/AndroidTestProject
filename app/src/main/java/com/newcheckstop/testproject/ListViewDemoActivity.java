package com.newcheckstop.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LIST_VIEW_DATA_COUNTS = "list_view_data_counts";
    public static final int DEFAULT_VALUE = 10;
    private ListView mPhoneBookListView;
    private List<UserInfo> userInfos;
    private int mDateCounts = 10;
    private PhoneBookAdapter mPhoneBookAdapter;
    private EditText mDataCountEditText;
    private Button mConfirmButton;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private void findViews() {
        mPhoneBookListView = (ListView) findViewById(R.id.list_view);
        mDataCountEditText = (EditText) findViewById(R.id.edit_data_counts);
        mConfirmButton = (Button) findViewById(R.id.button_data_counts);
    }
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        //系统会自动帮我们创建一个XML文件，名字是"perference_name"
        mSharedPreferences = getSharedPreferences("perference_name", Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        preference_listener();
        findViews();

        setData();

        setListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            }
        });
    }

    private void setListeners() {
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
                    mPhoneBookAdapter.refreshData(userInfos);
                }
                Toast.makeText(ListViewDemoActivity.this, userInfos.get(position).getUmserName()+"被我点击了",Toast.LENGTH_LONG).show();
            }
        });
        mConfirmButton.setOnClickListener(this);
    }

    private void setData() {
        mDateCounts = mSharedPreferences.getInt(LIST_VIEW_DATA_COUNTS, DEFAULT_VALUE);
        mDataCountEditText.setText(String.valueOf(mDateCounts));
        userInfos = new ArrayList<>();
        for (int index = 0; index < mDateCounts; index++) {
            userInfos.add(new UserInfo("电击方块",55));
        }

        mPhoneBookAdapter = new PhoneBookAdapter(ListViewDemoActivity.this, userInfos);
        mPhoneBookListView.setAdapter(mPhoneBookAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_data_counts:
                String countString = mDataCountEditText.getText().toString();
                mDateCounts = Integer.parseInt(countString);
                refreshListView();
                saveDatatPreference(mDateCounts);
        }
    }

    private void saveDatatPreference(int dataCounts) {
        mEditor.putInt(LIST_VIEW_DATA_COUNTS,dataCounts);
        //异步存储。与网络相关和IO草错相关的，都要用异步
        mEditor.apply();

    }

    private void preference_listener() {

        mSharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.i("ListViewDemoActivity",key);
            }
        });
    }

    private void refreshListView() {
        userInfos.clear();
        for (int index = 0; index < mDateCounts; index++) {
            userInfos.add(new UserInfo("电击方块",55));
        }
        mPhoneBookAdapter.refreshData(userInfos);
    }
}