package com.edge.weather.unithon;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c2619 on 2018-01-23.
 */

public class ScheduleVO  implements Parcelable{
    private String title;
    private String content;

    protected ScheduleVO(Parcel in) {
        title = in.readString();
        content = in.readString();
    }

    public static final Creator<ScheduleVO> CREATOR = new Creator<ScheduleVO>() {
        @Override
        public ScheduleVO createFromParcel(Parcel in) {
            return new ScheduleVO(in);
        }

        @Override
        public ScheduleVO[] newArray(int size) {
            return new ScheduleVO[size];
        }
    };

    public ScheduleVO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
    }
}
