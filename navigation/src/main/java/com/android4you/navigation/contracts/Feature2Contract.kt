package com.android4you.navigation.contracts

import android.app.Activity
import android.os.Parcelable
import com.android4you.navigation.BaseContract
import kotlinx.parcelize.Parcelize

class Feature2Contract(activityClass: Class<out Activity>) : BaseContract<Feature2Contract.Args, Feature2Contract.Result>(activityClass) {

    @Parcelize
    data class Args(
        val argument1: String
    ) : Parcelable

    @Parcelize
    data class Result(
        val result1: String
    ) : Parcelable
}
