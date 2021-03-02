package pl.wmariusz.hedgehopt.core.extension

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.newBuilder(newValue: T.() -> T) = newValue(this.value!!)