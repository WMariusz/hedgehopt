package pl.wmariusz.hedgehopt.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.wmariusz.hedgehopt.core.event.Event
import pl.wmariusz.hedgehopt.core.event.setEvent
import pl.wmariusz.hedgehopt.core.extension.newBuilder
import pl.wmariusz.hedgehopt.infrastructure.Hedgehog
import pl.wmariusz.hedgehopt.infrastructure.HedgehogRepository
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: HedgehogRepository
) : ViewModel() {

    private val _viewState = MutableLiveData(ViewState())
    val viewState: LiveData<ViewState>
        get() = _viewState

    private val _viewEvent = MutableLiveData<Event<ViewEvent>>()
    val viewEvent: LiveData<Event<ViewEvent>>
        get() = _viewEvent

    fun updateList() {
        _viewState.value = _viewState.newBuilder { copy(data = repository.hedgehogs()) }
    }

    fun selectHedgehog(hedgehog: Hedgehog) {
        _viewEvent.setEvent(ViewEvent.GoToDetails(hedgehog))
    }

    data class ViewState(
        val data: List<Hedgehog> = emptyList()
    )

    sealed class ViewEvent {
        data class GoToDetails(val hedgehog: Hedgehog) : ViewEvent()
    }
}