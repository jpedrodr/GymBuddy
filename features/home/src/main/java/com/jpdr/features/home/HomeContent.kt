package com.jpdr.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jpdr.gbcompose.preview.PreviewWithModes
import com.jpdr.gbcompose.theme.GymBuddyTheme

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text("HOME")
        Text("Summary of progress, upcoming workouts, and achievements.")
    }
}

@PreviewWithModes
@Composable
fun HomeContentPreview() {
    GymBuddyTheme {
        HomeContent()
    }
}
