package pl.wmariusz.hedgehopt.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.wmariusz.hedgehopt.theme.Dimen

@Composable
fun ImageLoadingPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(Dimen.ImageLoaderHeight),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}