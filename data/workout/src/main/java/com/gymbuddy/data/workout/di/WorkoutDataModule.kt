package com.gymbuddy.data.workout.di

import com.gymbuddy.data.workout.repository.WorkoutRepositoryImpl
import com.gymbuddy.domain.workout.repository.WorkoutRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WorkoutDataModule {

    @Binds
    abstract fun bindWorkoutRepository(
        impl: WorkoutRepositoryImpl
    ): WorkoutRepository
}