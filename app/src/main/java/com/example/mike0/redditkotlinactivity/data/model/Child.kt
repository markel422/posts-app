package com.example.mike0.redditkotlinactivity.data.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Child : Parcelable {

    @SerializedName("kind")
    @Expose
    var kind: String? = null
    @SerializedName("data")
    @Expose
    var data: Post? = null

    protected constructor(`in`: Parcel) {
        this.kind = `in`.readValue(String::class.java.classLoader) as String
        this.data = `in`.readValue(Post::class.java.classLoader) as Post
    }

    companion object {
        val CREATOR: Parcelable.Creator<Child> = object : Parcelable.Creator<Child> {

            override fun createFromParcel(`in`: Parcel): Child {
                return Child(`in`)
            }

            override fun newArray(size: Int): Array<Child?> {
                return arrayOfNulls(size)
            }
        }
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(kind)
        dest.writeValue(data)
    }

    override fun describeContents(): Int {
        return 0
    }
}