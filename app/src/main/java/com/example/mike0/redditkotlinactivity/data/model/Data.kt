package com.example.mike0.redditkotlinactivity.data.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data : Parcelable {

    @SerializedName("after")
    @Expose
    var after: String? = null
    @SerializedName("dist")
    @Expose
    var dist: Int? = null
    @SerializedName("modhash")
    @Expose
    var modhash: String? = null
    @SerializedName("whitelist_status")
    @Expose
    var whitelistStatus: String? = null
    @SerializedName("children")
    @Expose
    var children: List<Child>? = null
    @SerializedName("before")
    @Expose
    var before: Any? = null

    protected constructor(`in`: Parcel) {
        this.after = `in`.readValue(String::class.java.classLoader) as String
        this.dist = `in`.readValue(Int::class.java.classLoader) as Int
        this.modhash = `in`.readValue(String::class.java.classLoader) as String
        this.whitelistStatus = `in`.readValue(String::class.java.classLoader) as String
        `in`.readList(this.children, com.example.mike0.redditkotlinactivity.data.model.Child::class.java.classLoader)
        this.before = `in`.readValue(Any::class.java.classLoader) as Any
    }

    companion object {
        val CREATOR: Parcelable.Creator<Data> = object : Creator<Data> {

            override fun createFromParcel(`in`: Parcel): Data {
                return Data(`in`)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(after)
        dest.writeValue(dist)
        dest.writeValue(modhash)
        dest.writeValue(whitelistStatus)
        dest.writeList(children)
        dest.writeValue(before)
    }

    override fun describeContents(): Int {
        return 0
    }
}
