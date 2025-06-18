package com.gymbuddy.feature.workout.mapper

import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.feature.workout.model.WorkoutPlanUiModel

internal fun WorkoutPlan.toUiModel() = WorkoutPlanUiModel(
    id = id,
    name = name,
    exercisesCount = exercises.count(),
    isSelected = false
)

fun List<WorkoutPlan>.toUiModel() = map { it.toUiModel() }