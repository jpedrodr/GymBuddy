package com.gymbuddy.feature.workout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme

@Composable
fun WorkoutContent(
    modifier: Modifier = Modifier,
    viewModel: WorkoutViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "WORKOUTS",
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Log a new workout or follow saved routines.",
            color = MaterialTheme.colorScheme.onBackground
        )

        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.elevatedButtonColors().copy(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Icon(
                imageVector = Icons.Filled.FitnessCenter,
                contentDescription = stringResource(R.string.start_workout),
                tint = MaterialTheme.colorScheme.onPrimary
            )

            Text(
                text = stringResource(R.string.start_workout),
                modifier = Modifier.padding(start = 8.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        FilledTonalButton(
            onClick = {},
            colors = ButtonDefaults.elevatedButtonColors().copy(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = stringResource(R.string.add_workout),
                tint = MaterialTheme.colorScheme.onSecondary
            )

            Text(
                text = stringResource(R.string.add_workout),
                modifier = Modifier.padding(start = 8.dp),
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
@PreviewWithModes
fun WorkoutContentPreview() {
    GymBuddyTheme {
        WorkoutContent()
    }
}