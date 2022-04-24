package com.android4you.feature1

import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import com.android4you.core.BaseActivity
import com.android4you.feature1.databinding.ActivityFeature1Binding
import com.android4you.navigation.contracts.Feature2Contract
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Feature1Activity : BaseActivity() {

    private lateinit var feature2ContractLauncher: ActivityResultLauncher<Feature2Contract.Args>
    private lateinit var binding: ActivityFeature1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeature1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        feature2ContractLauncher = registerForActivityResult(contracts.feature2Contract) {
            if (it != null) {
                Log.e("Result -- >", it.result1)
            }
        }

        binding.buttonNavFeature2.setOnClickListener {
            feature2ContractLauncher.launch(Feature2Contract.Args("My Dummy data"))
        }

        binding.buttonNavFeature3.setOnClickListener {
            contracts.feature3Contract.launch()
        }
    }
}
