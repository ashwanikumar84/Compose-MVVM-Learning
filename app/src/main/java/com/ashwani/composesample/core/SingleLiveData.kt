package com.ashwani.composesample.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveData<T> : MutableLiveData<T>() {

    val liveDataState = AtomicBoolean(false)
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)
    }

    override fun setValue(value: T) {
        liveDataState.set(true)
        super.setValue(value)
    }

    override fun postValue(value: T) {
        super.postValue(value)
    }
}