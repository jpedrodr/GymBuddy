package com.gymbuddy.domain.workout.model

/**
 * Defines a set of exercise
 * Ex: set number 2, 10 reps with 20 kgs
 */
data class SetLog(
    val setNumber: Int,
    val reps: Int,
    val weight: Float? // Optional, for weight-based exercises
)