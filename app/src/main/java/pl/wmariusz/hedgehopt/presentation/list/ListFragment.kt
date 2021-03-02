package pl.wmariusz.hedgehopt.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import pl.wmariusz.hedgehopt.R
import pl.wmariusz.hedgehopt.core.event.observeEvent
import pl.wmariusz.hedgehopt.infrastructure.Hedgehog

@AndroidEntryPoint
class ListFragment: Fragment() {

    private val viewModel: ListViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            ListUi(getString(R.string.app_name), viewModel)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.viewEvent.observeEvent(viewLifecycleOwner) {event ->
            when(event) {
                is ListViewModel.ViewEvent.GoToDetails -> goToDetails(event.hedgehog)
            }
        }
    }

    private fun goToDetails(hedgehog: Hedgehog) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(hedgehog)
        findNavController().navigate(action)
    }

    override fun onStart() {
        super.onStart()
        viewModel.updateList()
    }

}