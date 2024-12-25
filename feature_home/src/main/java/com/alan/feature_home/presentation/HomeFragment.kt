package com.alan.feature_home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alan.core.di.CoreComponentProvider
import com.alan.feature_home.R
import com.alan.feature_home.di.DaggerHomeComponent
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coreComponent = (requireContext().applicationContext as CoreComponentProvider).coreComponent
        val homeComponent = DaggerHomeComponent.builder()
            .coreComponent(coreComponent)
            .build()
        homeComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.numbering_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.fetchData()
    }
}

