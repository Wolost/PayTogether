package com.example.pt.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopAppBar(
    title: String,
    showBackIcon: Boolean,
    onBackClick: () -> Unit
) {
    val appBarHeight = 56.dp
    val backgroundColor = Color(0xFF33AAFE)
    val iconColor = Color.White
    val iconSize = 24.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(appBarHeight)
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (showBackIcon) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = iconColor,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(iconSize)
                            .clickable { onBackClick() }
                    )
                }
                Text(
                    text = title,
                    color = iconColor,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = iconColor,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(iconSize)
                        .clickable {}
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = iconColor,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(iconSize)
                        .clickable {}
                )
            }
        }
    }
}

