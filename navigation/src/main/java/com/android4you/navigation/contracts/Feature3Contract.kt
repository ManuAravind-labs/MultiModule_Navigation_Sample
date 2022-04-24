package com.android4you.navigation.contracts

import android.app.Activity
import com.android4you.navigation.BaseContract
import com.android4you.navigation.NoArgs
import com.android4you.navigation.NoResult

class Feature3Contract(activityClass: Class<out Activity>) : BaseContract<NoArgs, NoResult>(activityClass)
