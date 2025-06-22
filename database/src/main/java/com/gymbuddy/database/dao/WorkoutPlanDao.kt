package com.gymbuddy.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gymbuddy.database.model.WorkoutPlanEntity

@Dao
interface WorkoutPlanDao {

    @Query("SELECT * FROM workout_plans ORDER BY id DESC")
    suspend fun getAllWorkoutPlans(): List<WorkoutPlanEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutPlan(workoutPlan: WorkoutPlanEntity)

    @Delete
    suspend fun deleteWorkoutPlan(workoutPlan: WorkoutPlanEntity)

    @Update
    suspend fun updateWorkoutPlan(workoutPlan: WorkoutPlanEntity)
}