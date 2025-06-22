package com.gymbuddy.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_plans")
data class WorkoutPlanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
)