package org.example.teagithubkmp.presentatioin.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

//@SuppressLint("UnrememberedMutableState")
//@ExperimentalMaterial3Api
@Composable
fun TTopBar(
    modifier: Modifier = Modifier,
    title: String,
    topPadding: PaddingValues = PaddingValues(0.dp),
    titleColor: Color = Color.Red,
    horizontalPadding: Dp = 20.dp,
    icon: Painter? = null,
    iconColor: Color = Color.Unspecified
) {

    Box(
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = horizontalPadding)
            .fillMaxWidth()
            .padding(top = topPadding.calculateTopPadding()),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Text(
//                text = title,
//                style = MaterialTheme.typography.titleLarge,
//                color = titleColor,
//            )
            icon?.let {
//                Icon(
//                    modifier = Modifier
//                        .padding(start = 8.dp)
//                        .size(26.dp),
//                    painter = icon,
//                    contentDescription = stringResource(R.string.header_icon),
//                    tint = iconColor
//                )
            }
        }
    }
}

@Preview
@Composable
fun TTopBarPreview() {
//    TeaGithubTheme {
//        TTopBar(
//            title = "Github Repositories",
//            icon = painterResource(id = R.drawable.github_logo),
//            iconColor = MaterialTheme.colorScheme.secondary
//        )
//    }
}