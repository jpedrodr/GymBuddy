package com.gymbuddy.domain.workout.usecase

import com.gymbuddy.core.IoDispatcher
import com.gymbuddy.domain.workout.repository.WorkoutRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetWorkoutPlansUseCase(
    private val repository: WorkoutRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke() = withContext(ioDispatcher) {
        repository.getWorkouts()
    }
}