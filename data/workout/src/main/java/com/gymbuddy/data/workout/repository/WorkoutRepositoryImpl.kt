package com.gymbuddy.data.workout.repository

import com.gymbuddy.domain.workout.repository.WorkoutRepository
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(): WorkoutRepository {
    override suspend fun getWorkouts(): List<String> {
        TODO("Not yet implemented")
    }
}