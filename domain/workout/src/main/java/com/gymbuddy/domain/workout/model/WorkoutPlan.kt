package com.gymbuddy.domain.workout.model

/**
 * A complete workout session with exercises
 */
data class WorkoutPlan(
    val id: String,
    val name: String, // e.g., "Leg Day"
    val exercises: List<Exercise>,
//    val duration: Int?, // Optional: estimated duration in minutes
//    val createdByUser: Boolean // Distinguish custom plans from defaults
)