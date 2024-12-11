package com.alan.android_sdk_task1.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alan.android_sdk_task1.R

class MainRouter(private val activity: AppCompatActivity) : Router {
    override fun navigateTo(fragment: Fragment) {
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun goBack() {
        activity.supportFragmentManager.popBackStack()
    }
}
