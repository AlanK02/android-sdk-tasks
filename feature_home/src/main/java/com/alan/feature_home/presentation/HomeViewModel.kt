package com.alan.feature_home.presentation

import com.alan.feature_home.data.network.FirstService
import com.alan.feature_home.data.network.SecondService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val firstService: FirstService,
    private val secondService: SecondService
) {
    fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val firstData = firstService.getFirstData()
                val secondData = secondService.getSecondData()

                println("First Data: $firstData")
                println("Second Data: $secondData")
            } catch (e: Exception) {
                println("Error fetching data: ${e.message}")
            }
        }
    }
}

