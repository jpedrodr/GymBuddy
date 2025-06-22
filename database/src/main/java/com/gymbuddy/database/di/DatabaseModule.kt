package com.gymbuddy.database.di

import android.content.Context
import androidx.room.Room
import com.gymbuddy.database.GymBuddyDatabase
import com.gymbuddy.database.dao.WorkoutPlanDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "gym_buddy_database"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GymBuddyDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = GymBuddyDatabase::class.java,
            name = DATABASE_NAME
        )
            .build()
    }

    @Provides
    fun provideWorkoutPlanDao(database: GymBuddyDatabase): WorkoutPlanDao =
        database.workoutPlanDao()
}