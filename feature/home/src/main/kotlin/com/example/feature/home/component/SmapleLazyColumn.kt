package com.example.feature.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyRow


@Composable
fun SampleListScreen(
    items: List<String>,
    onItemClick: (String) -> Unit
) {
    LazyColumn {
        items(items) { item ->
            SampleListItem(
                text = item,
                onClick = { onItemClick(item) }
            )
        }
    }

    LazyRow {
        items(items) { item ->
            SampleListItem(
                text = item,
                onClick = { onItemClick(item) }
            )
        }
    }
}

@Composable
fun SampleListItem(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() }
    )
}
