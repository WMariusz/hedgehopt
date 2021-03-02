package pl.wmariusz.hedgehopt.core.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

inline fun <T> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onEventUnhandledContent: (T) -> Unit
) {
    observe(owner, EventObserver { onEventUnhandledContent(it) })
}

fun <T> MutableLiveData<Event<T>>.setEvent(eventValue: T) {
    value = Event(eventValue)
}