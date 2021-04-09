package com.newcheckstop.testproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

//        FragmentManager fragmentManager = getFragmentManager();
//
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        TestFragment testFragment = TestFragment.newInstance("我是BIGBOSS", 20);
//        fragmentTransaction.add(R.id.fragment_view,testFragment);
//
//        fragmentTransaction.addToBackStack("TestFragment").commit();
//
//        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//            @Override
//            public void onBackStackChanged() {
//                Log.i(TestFragment.TAG,"onBackStackChanged");
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.i(TestFragment.TAG,"onBackPressed");
    }
}
