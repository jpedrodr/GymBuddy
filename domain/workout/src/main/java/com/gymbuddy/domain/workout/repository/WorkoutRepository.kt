package com.gymbuddy.domain.workout.repository

interface WorkoutRepository {
    suspend fun getWorkouts(): List<String>
}