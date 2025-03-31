package com.gymbuddy.feature.workout.ui.session

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ONE_SECOND_IN_MILLIS = 1000L
class WorkoutSessionViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(WorkoutSessionState())
    val uiState = _uiState.asStateFlow()

    private var timerJob: Job? = null

    fun handleIntent(intent: WorkoutSessionIntent) {
        when(intent) {
            WorkoutSessionIntent.ToggleTimer -> toggleTimer()
        }
    }

    private fun toggleTimer() {
        _uiState.update {
            val newIsTimerRunning = !it.timer.isRunning

            if (newIsTimerRunning) {
                startTimer()
            } else {
                stopTimer()
            }

            val updatedTimer = it.timer.copy(isRunning = newIsTimerRunning)
            it.copy(timer = updatedTimer)
        }
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (isActive) {
                delay(ONE_SECOND_IN_MILLIS)
                incrementTimer()
            }
        }
    }

    private fun incrementTimer() {
        _uiState.update {
            val updatedTimer = it.timer.copy(
                time = it.timer.time + ONE_SECOND_IN_MILLIS
            )
            it.copy(timer = updatedTimer)
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }
}

sealed class WorkoutSessionIntent {
    data object ToggleTimer : WorkoutSessionIntent()
}

@Immutable
data class WorkoutSessionState(
    val isLoading: Boolean = false,
    val timer: Timer = Timer()
)

@Immutable
data class Timer(
    val isRunning: Boolean = false,
    val time: Long = 0
)

//sealed class WorkoutSessionEvent {
//    data class StartWorkout(val workoutPlan: WorkoutPlanUiModel) : WorkoutSessionEvent()
//}
