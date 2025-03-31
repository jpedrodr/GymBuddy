package com.gymbuddy.feature.workout.ui.session

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WorkoutSessionContentUI(
    workoutPlanId: String,
    modifier: Modifier = Modifier,
    viewModel: WorkoutSessionViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("WorkoutSessionContentUI workoutPlanId=$workoutPlanId")

        Button(
            onClick = { viewModel.handleIntent(WorkoutSessionIntent.ToggleTimer) }
        ) {
            val text by rememberUpdatedState(
                if (uiState.timer.isRunning) "Stop" else "Start"
            )

            Text(text = text)
        }
        TimerUI(timer = uiState.timer)
    }
}

@Composable
private fun TimerUI(timer: Timer, modifier: Modifier = Modifier) {
    Text("Time is ${formatTime(timer.time)}")
}

private fun formatTime(milliseconds: Long): String {
    val seconds = milliseconds / 1000
    val minutes = seconds / 60
    val secs = seconds % 60
    return "%02d:%02d".format(minutes, secs)
}