package pl.wmariusz.hedgehopt.presentation.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.wmariusz.hedgehopt.infrastructure.Hedgehog
import pl.wmariusz.hedgehopt.theme.Dimen
import pl.wmariusz.hedgehopt.theme.HedgehoptTheme

typealias OnClickListener = (Hedgehog) -> Unit

@Composable
fun ListUi(title: String, viewModel: ListViewModel) {
    val viewState: ListViewModel.ViewState by viewModel.viewState.observeAsState(
        ListViewModel.ViewState()
    )

    HedgehoptTheme {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = title)
            })
        }) {
            ListView(items = viewState.data, onClick = viewModel::selectHedgehog)
        }
    }
}

@Composable
fun ListView(items: List<Hedgehog>, onClick: OnClickListener) {
    LazyColumn(
        contentPadding = PaddingValues(Dimen.Space16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(items = items) { index, item ->
            ListItemUi(hedgehog = item, onClick = onClick)
            if (index < items.size - 1) {
                Spacer(modifier = Modifier.requiredHeight(Dimen.Space16))
            }
        }
    }
}

@Preview
@Composable
fun PreviewList() {
    ListView(
        items = listOf(
            Hedgehog(
                "Name",
                0,
                "White",
                "Quite nice hedgehog",
                "https://images.pexels.com/photos/162200/hedgehog-hard-working-build-shelter-162200.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
            ), Hedgehog(
                "Name",
                0,
                "White",
                "Quite nice hedgehog",
                "https://images.pexels.com/photos/162200/hedgehog-hard-working-build-shelter-162200.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
            )
        ),
        onClick = { }
    )
}