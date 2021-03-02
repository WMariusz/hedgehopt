package pl.wmariusz.hedgehopt.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.coil.CoilImage
import pl.wmariusz.hedgehopt.infrastructure.Hedgehog
import pl.wmariusz.hedgehopt.theme.Dimen
import pl.wmariusz.hedgehopt.theme.HedgehoptTheme
import pl.wmariusz.hedgehopt.ui.ImageLoadingPlaceholder

@Composable
fun DetailUi(hedgehog: Hedgehog) {
    HedgehoptTheme {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = hedgehog.name)
            })
        }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                CoilImage(
                    data = hedgehog.photoUrl,
                    contentDescription = null,
                    loading = { ImageLoadingPlaceholder() }
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Start)
                        .padding(Dimen.Space16)
                ) {
                    Text(
                        text = hedgehog.name,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = "${hedgehog.age} years",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = "Color ${hedgehog.color}",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(Dimen.Space16))
                    Text(
                        text = hedgehog.description
                    )
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Adopt")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewDetailsUi() {
    DetailUi(
        hedgehog = Hedgehog(
            "Name",
            0,
            "White",
            "Quite nice hedgehog",
            "https://images.pexels.com/photos/162200/hedgehog-hard-working-build-shelter-162200.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
        )
    )
}