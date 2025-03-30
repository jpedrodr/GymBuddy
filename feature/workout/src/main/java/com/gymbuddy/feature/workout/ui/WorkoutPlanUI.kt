package com.gymbuddy.feature.workout.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gymbuddy.feature.workout.R
import com.gymbuddy.feature.workout.model.WorkoutPlan
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme

@Composable
fun WorkoutPlanUI(workoutPlan: WorkoutPlan, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = workoutPlan.name,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = stringResource(R.string.number_of_exercises, workoutPlan.exercises.count()),
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
@PreviewWithModes
fun WorkoutPlanUIPreview() {
    val workoutPlan = WorkoutPlan(
        id = "1",
        name = "Workout plan #1",
        exercises = emptyList()
    )
    GymBuddyTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            WorkoutPlanUI(workoutPlan = workoutPlan)
        }
    }
}