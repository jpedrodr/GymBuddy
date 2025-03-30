package com.gymbuddy.feature.workout

import androidx.lifecycle.ViewModel
import com.gymbuddy.feature.workout.model.WorkoutPlan
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutListState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(plans = getDummyWorkoutPlans())
        }
    }

    private fun getDummyWorkoutPlans(): List<WorkoutPlan> {
        return (1..12).map {
            WorkoutPlan(
                id = it.toString(),
                name = "Workout plan #$it",
                exercises = emptyList()
            )
        }
    }
}

data class WorkoutListState(
    val isLoading: Boolean = false,
    val plans: List<WorkoutPlan> = emptyList()
)