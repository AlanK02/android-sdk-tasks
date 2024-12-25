package com.alan.android_sdk_task1.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alan.android_sdk_task1.databinding.ActivityMainBinding
import com.alan.core.di.CoreComponent
import com.alan.core.di.CoreComponentProvider
import com.alan.feature_home.presentation.HomeFragment

class MainActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, HomeFragment())
                .commit()
        }
    }
}
