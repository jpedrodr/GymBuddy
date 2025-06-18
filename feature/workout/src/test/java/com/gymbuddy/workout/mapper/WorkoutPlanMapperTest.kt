package com.gymbuddy.workout.mapper

import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.feature.workout.mapper.toUiModel
import com.gymbuddy.feature.workout.model.WorkoutPlanUiModel
import org.junit.Assert.assertEquals
import org.junit.Test

class WorkoutPlanMapperTest {

    @Test
    fun `toUiModel - maps a WorkoutPlan correctly`() {
        val dataModel = WorkoutPlan(id = "plan1", name = "Chest Day", exercises = emptyList())

        val result = dataModel.toUiModel()

        val expected = WorkoutPlanUiModel(id = "plan1", name = "Chest Day", exercisesCount = 0)
        assertEquals(expected, result)
    }

    @Test
    fun `toUiModel - maps a list of WorkoutPlan correctly`() {
        val dataModels = listOf(
            WorkoutPlan(id = "plan1", name = "Chest Day", exercises = emptyList()),
            WorkoutPlan(id = "plan2", name = "Leg Day", exercises = emptyList())
        )

        val result = dataModels.toUiModel()

        val expected = listOf(
            WorkoutPlanUiModel(id = "plan1", name = "Chest Day", exercisesCount = 0),
            WorkoutPlanUiModel(id = "plan2", name = "Leg Day", exercisesCount = 0)
        )


        assertEquals(expected, result)
    }
}