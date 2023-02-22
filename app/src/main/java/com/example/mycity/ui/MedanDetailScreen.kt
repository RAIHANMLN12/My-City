package com.example.mycity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.ui.theme.MyCityTheme


@Composable
fun MedanDetailScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detail",
                        color = MaterialTheme.colors.surface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = MaterialTheme.colors.surface
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.secondary
            )
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary)
                .padding(it),
        ) {
            HeaderScreen()
            Detail()
        }
    }

}

@Composable
fun Detail() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.medan_detail),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.surface,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Composable
fun HeaderScreen() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Medan",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.surface,
            modifier = Modifier.padding(15.dp)
        )
    }
}


@Preview("Medan Detail Screen Preview")
@Composable
fun MedanDetailScreenPreview() {
    MyCityTheme(darkTheme = false) {
        MedanDetailScreen(onBackClick = {})
    }
}