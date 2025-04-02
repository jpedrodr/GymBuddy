package com.gymbuddy.data.workout.repository

import com.gymbuddy.domain.workout.repository.WorkoutRepository

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getWorkouts(): List<String> {
        TODO("Not yet implemented")
    }
}