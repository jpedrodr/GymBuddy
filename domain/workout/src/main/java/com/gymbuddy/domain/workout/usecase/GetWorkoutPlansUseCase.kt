package com.gymbuddy.domain.workout.usecase

import com.gymbuddy.core.IoDispatcher
import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.domain.workout.repository.WorkoutRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWorkoutPlansUseCase @Inject constructor(
    private val repository: WorkoutRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): List<WorkoutPlan> = withContext(ioDispatcher) {
        repository.getWorkoutPlans()
    }
}