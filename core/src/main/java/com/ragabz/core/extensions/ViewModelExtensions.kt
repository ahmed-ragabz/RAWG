package com.ragabz.core.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.runOnIoDispatchers(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.IO) {
        block()
    }
}
fun ViewModel.runOnMainDispatchers(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.Main) {
        block()
    }
}

