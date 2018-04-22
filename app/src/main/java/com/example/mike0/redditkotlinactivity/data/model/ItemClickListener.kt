package com.example.mike0.redditkotlinactivity.data.model

import android.view.View

/**
 * Created by mike0 on 4/21/2018.
 */

interface ItemClickListener {
    fun onClick(view: View, position: Int)
}