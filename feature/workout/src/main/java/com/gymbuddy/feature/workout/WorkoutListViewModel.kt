package com.gymbuddy.feature.workout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gymbuddy.feature.workout.model.WorkoutPlanUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class WorkoutListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutListState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<WorkoutListEvent>()
    val events = _events.asSharedFlow()

    init {
        _uiState.update {
            it.copy(plans = getDummyWorkoutPlans())
        }
    }

    fun handleIntent(intent: WorkoutListIntent) {
        when (intent) {
            is WorkoutListIntent.TogglePlanSelection -> togglePlanSelection(intent.workoutPlan)
            WorkoutListIntent.AddWorkout -> TODO()
            WorkoutListIntent.StartWorkout -> {
                val workoutPlan = _uiState.value.plans.find { it.isSelected } ?: return
                viewModelScope.launch {
                    _events.emit(WorkoutListEvent.StartWorkout(workoutPlan))
                }
            }
        }
    }

    private fun togglePlanSelection(workoutPlan: WorkoutPlanUiModel) {
        _uiState.update { state ->
            val updatedPlans = state.plans.map {
                if (it.id == workoutPlan.id) {
                    it.copy(isSelected = !it.isSelected)
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
    data class TogglePlanSelection(val workoutPlan: WorkoutPlanUiModel) : WorkoutListIntent()
    data object AddWorkout : WorkoutListIntent()
    data object StartWorkout : WorkoutListIntent()
}

sealed class WorkoutListEvent {
    data class StartWorkout(val workoutPlan: WorkoutPlanUiModel) : WorkoutListEvent()
}

data class WorkoutListState(
    val isLoading: Boolean = false,
    val plans: List<WorkoutPlanUiModel> = emptyList(),
) {
    val canStartWorkout: Boolean
        get() = plans.any { it.isSelected }
}