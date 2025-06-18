package com.gymbuddy.data.workout.mapper

import com.gymbuddy.data.workout.model.WorkoutPlanDataModel
import com.gymbuddy.domain.workout.model.WorkoutPlan
import org.junit.Assert.assertEquals
import org.junit.Test

class WorkoutPlanMapperTest {

    @Test
    fun `toDomainModel - maps a WorkoutPlanDataModel correctly`() {
        val dataModel = WorkoutPlanDataModel(id = "plan1", name = "Chest Day")

        val result = dataModel.toDomainModel()

        val expected = WorkoutPlan(id = "plan1", name = "Chest Day", exercises = emptyList())
        assertEquals(expected, result)
    }

    @Test
    fun `toDomainModel - maps a list of WorkoutPlanDataModel correctly`() {
        val dataModels = listOf(
            WorkoutPlanDataModel(id = "plan1", name = "Chest Day"),
            WorkoutPlanDataModel(id = "plan2", name = "Leg Day")
        )

        val result = dataModels.toDomainModel()

        val expected = listOf(
            WorkoutPlan(id = "plan1", name = "Chest Day", exercises = emptyList()),
            WorkoutPlan(id = "plan2", name = "Leg Day", exercises = emptyList())
        )

        assertEquals(expected, result)
    }
}