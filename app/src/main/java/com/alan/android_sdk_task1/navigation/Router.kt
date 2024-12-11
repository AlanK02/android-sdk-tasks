package com.alan.android_sdk_task1.navigation

import androidx.fragment.app.Fragment

interface Router {
    fun navigateTo(fragment: Fragment)
    fun goBack()
}
