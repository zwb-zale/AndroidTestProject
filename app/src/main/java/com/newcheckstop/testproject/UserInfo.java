package com.newcheckstop.testproject;

import android.widget.ImageView;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String umserName;
    private int mAge;
    private String mAvatarUrl;
    private float mWeight;

    public UserInfo(String umserName, int age) {
        this.umserName = umserName;
        mAge = age;
    }

    public String getUmserName() {
        return umserName;
    }

    public void setUmserName(String umserName) {
        this.umserName = umserName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public float getWeight() {
        return mWeight;
    }

    public void setWeight(float weight) {
        mWeight = weight;
    }
}
