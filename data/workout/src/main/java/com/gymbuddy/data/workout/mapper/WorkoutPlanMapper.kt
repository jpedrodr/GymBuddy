package com.gymbuddy.data.workout.mapper

import com.gymbuddy.data.workout.model.WorkoutPlanDataModel
import com.gymbuddy.database.model.WorkoutPlanEntity
import com.gymbuddy.domain.workout.model.WorkoutPlan

internal fun WorkoutPlanDataModel.toDomainModel() = WorkoutPlan(
    id = id,
    name = name,
    exercises = emptyList() // joaorosa fix this
)

fun List<WorkoutPlanDataModel>.toDomainModel() = map { it.toDomainModel() }


internal fun WorkoutPlanEntity.toDataModel() = WorkoutPlanDataModel(
    id = id,
    name = name,
//    exercises = emptyList() // joaorosa fix this
)

fun List<WorkoutPlanEntity>.toDataModel() = map { it.toDataModel() }