package com.gymbuddy.domain.workout.repository

import com.gymbuddy.domain.workout.model.WorkoutPlan

interface WorkoutRepository {
    suspend fun getWorkoutPlans(): List<WorkoutPlan>
}