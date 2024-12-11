package com.alan.android_sdk_task1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.alan.android_sdk_task1.R
import com.alan.android_sdk_task1.navigation.Router

class Fragment2(private val router: Router) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment2, container, false)

        val prevButton: Button = view.findViewById(R.id.prev_button)
        val nextButton: Button = view.findViewById(R.id.next_button)

        prevButton.setOnClickListener {
            router.goBack()
        }

        nextButton.setOnClickListener {
            router.navigateTo(Fragment3(router))
        }

        return view
    }
}
