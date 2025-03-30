package com.gymbuddy.feature.workout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gymbuddy.feature.workout.R
import com.gymbuddy.feature.workout.WorkoutListViewModel
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme

@Composable
fun WorkoutListContentUI(
    modifier: Modifier = Modifier,
    viewModel: WorkoutListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Text(
            text = "WORKOUTS",
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Log a new workout or follow saved routines.",
            color = MaterialTheme.colorScheme.onBackground
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 64.dp)
            ) {
                uiState.plans.forEach {
                    WorkoutPlanUI(it)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                StartWorkoutButton(onClick = {}, modifier = Modifier.align(Alignment.Center))
                AddWorkoutButton(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd))
            }
        }
    }
}

@Composable
private fun StartWorkoutButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp),
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
}

@Composable
private fun AddWorkoutButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            modifier = Modifier.size(28.dp),
            contentDescription = stringResource(R.string.add_workout),
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
@PreviewWithModes
fun WorkoutContentPreview() {
    GymBuddyTheme {
        WorkoutListContentUI()
    }
}