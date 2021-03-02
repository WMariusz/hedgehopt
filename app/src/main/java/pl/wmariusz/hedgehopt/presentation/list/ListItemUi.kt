package pl.wmariusz.hedgehopt.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.coil.CoilImage
import pl.wmariusz.hedgehopt.infrastructure.Hedgehog
import pl.wmariusz.hedgehopt.theme.Dimen
import pl.wmariusz.hedgehopt.theme.HedgehoptTheme
import pl.wmariusz.hedgehopt.ui.ImageLoadingPlaceholder

@Composable
fun ListItemUi(hedgehog: Hedgehog, onClick: OnClickListener) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(Dimen.Space8))
            .indication(
                remember { MutableInteractionSource() },
                rememberRipple(bounded = false)
            )
            .clickable { onClick(hedgehog) }
    ) {
        CoilImage(
            data = hedgehog.photoUrl,
            contentDescription = null,
            loading = { ImageLoadingPlaceholder() }
        )
        Text(
            text = "${hedgehog.name} • ${hedgehog.age} years",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(MaterialTheme.colors.secondary)
                .padding(Dimen.Space16)
                .clipToBounds()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListItemUi() {
    HedgehoptTheme {
        ListItemUi(
            hedgehog = Hedgehog(
                "Name",
                0,
                "White",
                "Quite nice hedgehog",
                "https://images.pexels.com/photos/162200/hedgehog-hard-working-build-shelter-162200.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
            )
        ) { }
    }
}