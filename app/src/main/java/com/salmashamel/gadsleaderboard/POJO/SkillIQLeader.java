package com.salmashamel.gadsleaderboard.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class SkillIQLeader implements Parcelable {

    private String name;
    private Integer score;
    private String country;
    private String badgeUrl;

    protected SkillIQLeader(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            score = null;
        } else {
            score = in.readInt();
        }
        country = in.readString();
        badgeUrl = in.readString();
    }

    public static final Creator<SkillIQLeader> CREATOR = new Creator<SkillIQLeader>() {
        @Override
        public SkillIQLeader createFromParcel(Parcel in) {
            return new SkillIQLeader(in);
        }

        @Override
        public SkillIQLeader[] newArray(int size) {
            return new SkillIQLeader[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
        parcel.writeInt(score);
        parcel.writeString(country);
        parcel.writeString(badgeUrl);
    }
}
