package com.newcheckstop.testproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class TestFragment extends Fragment {

    public static final String  TAG = TestFragment.class.getSimpleName();
    public static final String ARGUMENT_NAME = "argument_name";
    public static final String ARGUMENT_NUMBER = "argument_number";
    private String mName="yyy";
    private int mNumber=123;

    public static TestFragment newInstance(String nameString, int number){
      TestFragment testFragment = new TestFragment();
      Bundle bundle = new Bundle();
      bundle.putString(ARGUMENT_NAME,nameString);
      bundle.putInt(ARGUMENT_NUMBER,number);
      testFragment.setArguments(bundle);
      return testFragment;
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            mName = bundle.getString(ARGUMENT_NAME);
            mNumber = bundle.getInt(ARGUMENT_NUMBER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //加载布局文件   此处是item_phone_book_friend.xml
        View view = inflater.inflate(R.layout.item_phone_book_friend,container, false);
        TextView nameTextView = (TextView) view.findViewById(R.id.name_text_view);
        TextView ageTextview = (TextView) view.findViewById(R.id.age_text_view);
        nameTextView.setText(mName);
        ageTextview.setText(mNumber+ "岁");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
