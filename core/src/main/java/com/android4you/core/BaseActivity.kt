package com.android4you.core

import android.app.Activity
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.android4you.navigation.BaseContract
import com.android4you.navigation.Contracts
import com.android4you.navigation.NoResult
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var contracts: Contracts

    fun <Args : Parcelable> BaseContract<Args, NoResult>.launch(args: Args? = null) {
        startActivity(this.createIntent(this@BaseActivity, args))
    }

    fun <Result : Parcelable> setContractResult(contract: BaseContract<*, Result>, result: Result) {
        setResult(Activity.RESULT_OK, contract.createResultIntent(result))
    }
}

inline fun <reified Args : Parcelable> Activity.contractArgs(crossinline lazyContract: () -> BaseContract<Args, *>): ReadOnlyProperty<Activity, Args> {
    return object : ReadOnlyProperty<Any, Args> {
        private var value: Args? = null
        override fun getValue(thisRef: Any, property: KProperty<*>): Args {
            if (value == null) {
                value = lazyContract().parseStartIntent(intent)
            }
            return value ?: throw RuntimeException("Missing contract args")
        }
    }
}
