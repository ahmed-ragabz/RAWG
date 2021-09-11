package com.ragabz.core.base

import androidx.lifecycle.MutableLiveData

class LoadingLiveState<T: LoadingState>: MutableLiveData<T>()