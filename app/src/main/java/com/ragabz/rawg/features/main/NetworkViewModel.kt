package com.ragabz.rawg.features.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sa.com.stc.core.livedata.SingleLiveData
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor() : ViewModel() {
    private val _connectionState: SingleLiveData<Boolean> = SingleLiveData()
    var connectionState: LiveData<Boolean> = _connectionState

    fun changeToConnected() {
        _connectionState.postValue(true)
    }

    fun changeToNotConnected() {
        _connectionState.postValue(false)
    }
    fun isConnected(): Boolean  = _connectionState.value ?: false
}