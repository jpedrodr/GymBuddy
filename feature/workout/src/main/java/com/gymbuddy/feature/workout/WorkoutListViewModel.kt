package com.gymbuddy.feature.workout

import androidx.lifecycle.ViewModel
import com.gymbuddy.domain.workout.model.WorkoutPlan
import com.gymbuddy.feature.workout.model.WorkoutPlanUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class WorkoutListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutListState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(plans = getDummyWorkoutPlans())
        }
    }

    fun handleIntent(intent: WorkoutListIntent) {
        when (intent) {
            is WorkoutListIntent.SelectPlan -> selectPlan(intent.workoutPlan)
        }
    }

    private fun selectPlan(workoutPlan: WorkoutPlanUiModel) {
        _uiState.update { state ->
            val updatedPlans = state.plans.map {
                if (it.id == workoutPlan.id) {
                    it.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }

            state.copy(plans = updatedPlans)
        }
    }

    private fun getDummyWorkoutPlans(): List<WorkoutPlanUiModel> {
        return (1..12).map {
            WorkoutPlanUiModel(
                id = it.toString(),
                name = "Workout plan #$it",
                exercisesCount = Random.nextInt(5, 9)
            )
        }
    }
}

sealed class WorkoutListIntent {
    data class SelectPlan(val workoutPlan: WorkoutPlanUiModel) : WorkoutListIntent()
}

data class WorkoutListState(
    val isLoading: Boolean = false,
    val plans: List<WorkoutPlanUiModel> = emptyList()
)