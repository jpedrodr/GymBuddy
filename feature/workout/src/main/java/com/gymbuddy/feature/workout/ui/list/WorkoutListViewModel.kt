package com.gymbuddy.feature.workout.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gymbuddy.domain.workout.usecase.GetWorkoutPlansUseCase
import com.gymbuddy.feature.workout.mapper.toUiModel
import com.gymbuddy.feature.workout.model.WorkoutPlanUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutListViewModel @Inject constructor(
    private val getWorkoutPlansUseCase: GetWorkoutPlansUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutListState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<WorkoutListEvent>()
    val events = _events.asSharedFlow()

    init {
        loadWorkoutPlans()
    }

    private fun loadWorkoutPlans() {
        _uiState.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            val workoutPlans = getWorkoutPlansUseCase().toUiModel()
            _uiState.update {
                it.copy(
                    isLoading = false,
                    workoutPlans = workoutPlans
                )
            }
        }
    }

    fun handleIntent(intent: WorkoutListIntent) {
        when (intent) {
            is WorkoutListIntent.TogglePlanSelection -> togglePlanSelection(intent.workoutPlan)
            WorkoutListIntent.AddWorkout -> TODO()
            WorkoutListIntent.StartWorkout -> {
                val workoutPlan = _uiState.value.workoutPlans.find { it.isSelected } ?: return
                viewModelScope.launch {
                    _events.emit(WorkoutListEvent.StartWorkout(workoutPlan))
                }
            }
        }
    }

    private fun togglePlanSelection(workoutPlan: WorkoutPlanUiModel) {
        _uiState.update { state ->
            val updatedPlans = state.workoutPlans.map {
                if (it.id == workoutPlan.id) {
                    it.copy(isSelected = !it.isSelected)
                } else {
                    it.copy(isSelected = false)
                }
            }

            state.copy(workoutPlans = updatedPlans)
        }
    }
}

sealed class WorkoutListIntent {
    data class TogglePlanSelection(val workoutPlan: WorkoutPlanUiModel) : WorkoutListIntent()
    data object AddWorkout : WorkoutListIntent()
    data object StartWorkout : WorkoutListIntent()
}

data class WorkoutListState(
    val isLoading: Boolean = false,
    val workoutPlans: List<WorkoutPlanUiModel> = emptyList(),
) {
    val canStartWorkout: Boolean
        get() = workoutPlans.any { it.isSelected }
}

sealed class WorkoutListEvent {
    data class StartWorkout(val workoutPlan: WorkoutPlanUiModel) : WorkoutListEvent()
}