package com.riid.jsonapisample.base.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.disposables.CompositeDisposable

abstract class BaseLifecycleViewModel : ViewModel() {

    val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        Log.i("BaseLifecycleViewModel", "onCleared!!!")
        disposables.clear()
    }
}