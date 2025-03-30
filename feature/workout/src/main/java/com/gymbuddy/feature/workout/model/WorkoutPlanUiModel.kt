package com.gymbuddy.feature.workout.model

import com.gymbuddy.domain.workout.model.WorkoutPlan

/**
 * A model used to represent a [WorkoutPlan] in the UI
 */
data class WorkoutPlanUiModel(
    val id: String,
    val name: String, // e.g., "Leg Day"
    val exercisesCount: Int,
    val isSelected: Boolean = false
//    val duration: Int?, // Optional: estimated duration in minutes
//    val createdByUser: Boolean // Distinguish custom plans from defaults
)