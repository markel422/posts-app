
package com.example.mike0.redditkotlinactivity.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsAPI implements Parcelable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Parcelable.Creator<PostsAPI> CREATOR = new Creator<PostsAPI>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostsAPI createFromParcel(Parcel in) {
            return new PostsAPI(in);
        }

        public PostsAPI[] newArray(int size) {
            return (new PostsAPI[size]);
        }

    }
    ;

    protected PostsAPI(Parcel in) {
        this.kind = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public PostsAPI() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
