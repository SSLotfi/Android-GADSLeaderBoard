package com.salmashamel.gadsleaderboard.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class LearningLeader implements Parcelable {

    private String name;
    private Integer hours;
    private String country;
    private String badgeUrl;

    protected LearningLeader(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            hours = null;
        } else {
            hours = in.readInt();
        }
        country = in.readString();
        badgeUrl = in.readString();
    }

    public static final Creator<LearningLeader> CREATOR = new Creator<LearningLeader>() {
        @Override
        public LearningLeader createFromParcel(Parcel in) {
            return new LearningLeader(in);
        }

        @Override
        public LearningLeader[] newArray(int size) {
            return new LearningLeader[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(hours);
        parcel.writeString(country);
        parcel.writeString(badgeUrl);
    }
}