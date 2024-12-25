package com.alan.feature_home.di

import com.alan.core.di.CoreComponent
import com.alan.feature_home.presentation.HomeFragment
import dagger.Component
import javax.inject.Scope

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [HomeModule::class])
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope
