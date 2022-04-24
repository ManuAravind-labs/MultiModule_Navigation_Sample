package com.android4you.multimoduleapplication.navContracts

import com.android4you.feature2.Feature2Activity
import com.android4you.feature3.Feature3Activity
import com.android4you.navigation.Contracts
import com.android4you.navigation.contracts.Feature2Contract
import com.android4you.navigation.contracts.Feature3Contract

class AppContracts : Contracts {
    override val feature2Contract = Feature2Contract(Feature2Activity::class.java)
    override val feature3Contract = Feature3Contract(Feature3Activity::class.java)
}
