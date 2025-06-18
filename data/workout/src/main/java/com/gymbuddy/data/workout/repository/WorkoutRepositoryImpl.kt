package com.gymbuddy.data.workout.repository

import com.gymbuddy.data.workout.mapper.toDomainModel
import com.gymbuddy.data.workout.model.WorkoutPlanDataModel
import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.domain.workout.repository.WorkoutRepository
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(): WorkoutRepository {
    override suspend fun getWorkouts(): List<WorkoutPlan> {
        val plans =  (1..12).map {
            WorkoutPlanDataModel(
                id = it.toString(),
                name = "Workout plan #$it",
//                exercisesCount = Random.nextInt(5, 9)
            )
        }

        return plans.toDomainModel()
    }
}