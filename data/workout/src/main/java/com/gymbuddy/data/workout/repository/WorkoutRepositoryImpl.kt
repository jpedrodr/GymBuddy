package com.gymbuddy.data.workout.repository

import com.gymbuddy.data.workout.mapper.toDataModel
import com.gymbuddy.data.workout.mapper.toDomainModel
import com.gymbuddy.database.dao.WorkoutPlanDao
import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.domain.workout.repository.WorkoutRepository
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val workoutPlanDao: WorkoutPlanDao
): WorkoutRepository {

    override suspend fun getWorkoutPlans(): List<WorkoutPlan> {
        val entities = workoutPlanDao.getAllWorkoutPlans().map {
            it.toDataModel()
        }

        println("joaorosa | getWorkoutPlans entities=${entities.size}")

        return entities.toDomainModel()
    }
}