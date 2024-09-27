package org.example.teagithubkmp.presentatioin.composable

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TFilledButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    contentColor: Color = Color.Blue,
    background: Color = Color.Red,
    textStyle: TextStyle = TextStyle.Default
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background,
            contentColor = contentColor,
        )
    ) {
        Text(
            text = label,
            style = textStyle,
            color = contentColor,
        )
    }
}

@Composable
@Preview
fun KFilledButtonPreview() {
//    TeaGithubTheme {
        TFilledButton(label = "Try Again", onClick = {})
//    }
}
