package com.gymbuddy.feature.workout.model

/**
 * Stores user-set data (actual reps, sets, weight).
 * Example: exercise = Front Row, sets = x sets
 */
data class ExerciseLog(
    val id: String,
    val exercise: Exercise,
    val sets: List<SetLog>
)