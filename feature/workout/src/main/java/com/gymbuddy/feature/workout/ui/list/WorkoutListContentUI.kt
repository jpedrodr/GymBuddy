package com.gymbuddy.feature.workout.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gymbuddy.feature.workout.R
import com.gymbuddy.feature.workout.ui.WorkoutPlanUI
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme
import com.gymbuddy.navigation.Destination
import com.gymbuddy.navigation.navigateTo

@Composable
fun WorkoutListContentUI(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: WorkoutListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is WorkoutListEvent.StartWorkout -> {
                    navController.navigateTo(Destination.WorkoutSession(event.workoutPlan.id))
                }
            }
        }
    }

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
            LazyColumn(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxSize()
                    .padding(bottom = 64.dp, top = 4.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = uiState.plans,
                    key = { it.id }
                ) {
                    WorkoutPlanUI(
                        workoutPlan = it,
                        onClick = { viewModel.handleIntent(WorkoutListIntent.TogglePlanSelection(it)) }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                StartWorkoutButtonUI(
                    onClick = { viewModel.handleIntent(WorkoutListIntent.StartWorkout) },
                    enabled = uiState.canStartWorkout,
                    modifier = Modifier.align(Alignment.Center)
                )
                AddWorkoutButtonUI(
                    onClick = { viewModel.handleIntent(WorkoutListIntent.AddWorkout) },
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Composable
private fun StartWorkoutButtonUI(
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp),
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
private fun AddWorkoutButtonUI(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
        WorkoutListContentUI(
            navController = rememberNavController()
        )
    }
}