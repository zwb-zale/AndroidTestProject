package com.newcheckstop.testproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private List<UserInfo> mUserInfo = new ArrayList<>();
    public GridViewAdapter(Context context , List<UserInfo> userInfos){
        mContext = context;
        mUserInfo = userInfos;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mUserInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //返回一个视图

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_phone_book_friend,null);
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.name_text_view);
            viewHolder.ageTextView = (TextView)  convertView.findViewById(R.id.age_text_view);
            viewHolder.avaterImageView = (ImageView) convertView.findViewById(R.id.avater_image_view);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView.setText(mUserInfo.get(position).getUmserName());
        viewHolder.ageTextView.setText(String.valueOf(mUserInfo.get(position).getAge()));
        viewHolder.avaterImageView.setImageResource(R.drawable.xunjianxitong);
        return convertView;
    }

    class ViewHolder{
        TextView nameTextView;
        TextView ageTextView;
        ImageView avaterImageView;
    }

    public void refreshData(List<UserInfo> userInfos){
        mUserInfo = userInfos;
        notifyDataSetChanged();
    }
}
