package com.example.mike0.redditkotlinactivity.data.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostsAPI : Parcelable {

    @SerializedName("kind")
    @Expose
    var kind: String? = null
    @SerializedName("data")
    @Expose
    var data: Data? = null

    protected constructor(`in`: Parcel) {
        this.kind = `in`.readValue(String::class.java.classLoader) as String
        this.data = `in`.readValue(Data::class.java.classLoader) as Data
    }

    companion object {
        val CREATOR: Parcelable.Creator<PostsAPI> = object : Creator<PostsAPI> {

            override fun createFromParcel(`in`: Parcel): PostsAPI {
                return PostsAPI(`in`)
            }

            override fun newArray(size: Int): Array<PostsAPI?> {
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
