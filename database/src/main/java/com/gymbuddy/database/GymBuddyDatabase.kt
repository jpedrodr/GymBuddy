package com.gymbuddy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gymbuddy.database.dao.WorkoutPlanDao
import com.gymbuddy.database.model.WorkoutPlanEntity

@Database(entities = [WorkoutPlanEntity::class], version = 1)
abstract class GymBuddyDatabase: RoomDatabase() {

    abstract fun workoutPlanDao(): WorkoutPlanDao
}