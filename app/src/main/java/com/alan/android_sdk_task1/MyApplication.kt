package com.alan.android_sdk_task1

import android.app.Application
import com.alan.core.di.CoreComponent
import com.alan.core.di.CoreComponentProvider
import com.alan.core.di.DaggerCoreComponent

class MyApplication : Application(), CoreComponentProvider {
    override val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
