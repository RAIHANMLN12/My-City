package com.example.mycity.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.model.Recommendation
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun DetailScreen(
    selectedRecommendation: Recommendation,
    onBackPressed: () -> Unit
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
                    IconButton(onClick =  { onBackPressed() } ) {
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
    ) { PaddingValues(30.dp)
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(selectedRecommendation.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(241.dp)
                    .padding(PaddingValues(top = 25.dp))
            )

            Spacer(modifier = Modifier.height(19.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = selectedRecommendation.name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.surface
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = selectedRecommendation.description,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.surface,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(PaddingValues(30.dp))
                    )
                }
            }

        }
    }
}

@Preview("Item Detail Screen Preview")
@Composable
fun DetailScreenPreview() {
    MyCityTheme(darkTheme = false) {
        DetailScreen(selectedRecommendation = LocalDataProvider.default, onBackPressed = {})


    }
}