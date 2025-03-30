package com.gymbuddy.feature.workout.model

/**
 * Defines an exercise with name, reps, etc.
 * This is a not an entry, rather a type. For specific entries, use [ExerciseLog]
 */
data class Exercise(
    val id: String,
    val name: String, // e.g., "Squat"
    val muscleGroup: String?, // e.g., "Legs"
    val defaultSets: Int?, // e.g, 3
    val defaultReps: Int? // e.g, 12
)