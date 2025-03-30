package com.gymbuddy.feature.workout.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gymbuddy.feature.workout.R
import com.gymbuddy.feature.workout.model.WorkoutPlanUiModel
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme

@Composable
fun WorkoutPlanUI(workoutPlan: WorkoutPlanUiModel, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val borderColor = if (workoutPlan.isSelected) MaterialTheme.colorScheme.secondary else Color.Transparent
    val cardShape = RoundedCornerShape(8.dp)
    Card(
        modifier = modifier.fillMaxWidth()
            .clip(cardShape)
            .clickable { onClick() }
            .border(
                width = 2.dp,
                color = borderColor,
                shape = cardShape
            ),
        colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = workoutPlan.name,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = stringResource(R.string.number_of_exercises, workoutPlan.exercisesCount),
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
@PreviewWithModes
fun WorkoutPlanUIPreview() {
    val workoutPlan = WorkoutPlanUiModel(
        id = "1",
        name = "Workout plan #1",
        exercisesCount = 5
    )
    GymBuddyTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            WorkoutPlanUI(
                workoutPlan = workoutPlan,
                onClick = {},
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}