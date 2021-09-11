package com.ragabz.core.base

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

abstract class BaseViewModel  : ViewModel(), Observable {
    val loadingLiveState = LoadingLiveState<LoadingState>()
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }

    fun notifyChange() {
        callbacks.notifyChange(this, 0)
    }

//    abstract fun <T: BaseViewState> changeViewState(viewState: T)

}
