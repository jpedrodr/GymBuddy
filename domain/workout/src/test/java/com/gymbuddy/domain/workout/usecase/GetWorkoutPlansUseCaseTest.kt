package com.gymbuddy.domain.workout.usecase

import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.domain.workout.repository.WorkoutRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetWorkoutPlansUseCaseTest {

    private val repository: WorkoutRepository = mockk()

    private val useCase = GetWorkoutPlansUseCase(
        repository = repository,
        ioDispatcher = UnconfinedTestDispatcher()
    )

    @Before
    fun setup() {
        coEvery { repository.getWorkouts() } returns listOf(
            WorkoutPlan(id = "1", name = "WorkoutPlan 1", exercises = emptyList()),
            WorkoutPlan(id = "2", name = "WorkoutPlan 2", exercises = emptyList())
        )
    }

    @Test
    fun `invoke - repository returns workouts - values match`() = runTest {
        val result = useCase()

        val expected = listOf(
            WorkoutPlan(id = "1", name = "WorkoutPlan 1", exercises = emptyList()),
            WorkoutPlan(id = "2", name = "WorkoutPlan 2", exercises = emptyList())
        )

        assertEquals(expected, result)
    }
}