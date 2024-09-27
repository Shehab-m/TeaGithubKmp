package com.teacomputers.teagithub.presentation.repos.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.teagithubkmp.presentatioin.repos.RepoUIState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ItemRepo(
    modifier: Modifier = Modifier,
    repo: RepoUIState,
    backgroundColor: Color = Color.Unspecified,
) {
    Column(modifier = modifier
        .background(backgroundColor)
        .fillMaxWidth()) {
        Box(modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
//                    Icon(
//                        modifier = Modifier.size(24.dp),
//                        painter = painterResource(id = R.drawable.github_logo),
//                        contentDescription = stringResource(R.string.github_icon),
//                        tint = MaterialTheme.colorScheme.primary
//                    )
//                    Text(
//                        text = repo.name,
//                        style = MaterialTheme.typography.labelMedium,
//                        color = MaterialTheme.colorScheme.onTertiary,
//                        textAlign = TextAlign.Center
//                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
//                    Text(
//                        text = stringResource(R.string.language, repo.language),
//                        style = MaterialTheme.typography.bodyLarge,
//                        color = MaterialTheme.colorScheme.onTertiary,
//                        textAlign = TextAlign.Center
//                    )
//                    Text(
//                        text = stringResource(R.string.private_label, repo.private),
//                        style = MaterialTheme.typography.bodyLarge,
//                        color = MaterialTheme.colorScheme.onTertiary,
//                        textAlign = TextAlign.Center
//                    )
//                }
//                Text(
//                    text = stringResource(R.string.branch, repo.defaultBranch),
//                    style = MaterialTheme.typography.bodyLarge,
//                    color = MaterialTheme.colorScheme.onTertiary,
//                    textAlign = TextAlign.Center
//                )
//                Text(
//                    text = stringResource(R.string.created_at, repo.createdAt),
//                    style = MaterialTheme.typography.bodyLarge,
//                    color = MaterialTheme.colorScheme.onTertiary,
//                    textAlign = TextAlign.Center
//                )
            }
//            ImageNetwork(
//                modifier = Modifier
//                    .size(36.dp)
//                    .align(Alignment.TopEnd),
//                imageUrl = repo.owner.avatarUrl
//            )
        }
        Box(modifier = Modifier.padding(top = 8.dp).height(1.dp).fillMaxWidth())
    }
}

@Preview
@Composable
fun ItemRepoPreview() {
//    TeaGithubTheme {
        ItemRepo(repo = RepoUIState())
    }
}