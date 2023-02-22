package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.data.LocalDataProvider
import com.example.mycity.model.Recommendation
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun HomeScreen(
    onMedanDetailClick: () -> Unit,
    onItemDetailClick: (Recommendation) -> Unit,
    recommendation: List <Recommendation>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        Header()
        Medan(onClick = onMedanDetailClick)
        RecommendationList(
            recommendation = recommendation,
            onDetailClick = { onItemDetailClick(it) }
        )
    }
}


@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "My City",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.surface
        )
    }
}

@Composable
fun Medan(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 19.dp, vertical = 42.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Medan",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.surface
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(0.dp)) {
            Text(
                text = "see more",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.surface,
                modifier = Modifier.padding(0.dp)
            )
                Icon(
                    imageVector = Icons.Filled.ArrowRight,
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { onClick() }
                )
        }
    }
}

@Composable
fun RecommendationItem(
    onClick: () -> Unit,
    recommendation: Recommendation
) {
        Card(
            modifier = Modifier
                .size(width = 143.dp, height = 164.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.background)
                .clickable { onClick() },
            backgroundColor = MaterialTheme.colors.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(recommendation.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 119.dp, height = 81.6.dp)
                        .padding(top = 8.16.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.height(10.24.dp))

                Text(
                    text = recommendation.name,
                    color = MaterialTheme.colors.surface,
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Place,
                        contentDescription = null,
                        tint = MaterialTheme.colors.surface,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = recommendation.location,
                        color = MaterialTheme.colors.surface,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(start = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.height(21.dp))
            }
        }

}

@Composable
fun RecommendationList(
    recommendation: List<Recommendation>,
    onDetailClick: (Recommendation) -> Unit
) {
    Column() {
        Text(
            text = "Recommendation Place",
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(horizontal = 21.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 21.dp, vertical = 21.dp),
            verticalArrangement = Arrangement.spacedBy(21.dp),
            horizontalArrangement = Arrangement.spacedBy(29.dp)
        ) {
            items(recommendation) {
                RecommendationItem(onClick = { onDetailClick(it) }, recommendation = it)
            }
        }
    }
}

@Preview("Home Screen Preview")
@Composable
private fun HomeScreenPreview() {
    MyCityTheme(darkTheme = false) {
        HomeScreen(
            onMedanDetailClick = {},
            onItemDetailClick = {},
            recommendation = LocalDataProvider.placeRecommendation(),
        )
    }
}