package website.tachi.app.presentation.ui.schedule

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.meokq.boss.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import website.tachi.app.domain.usecase.GetScheduleUseCase
import website.tachi.app.presentation.state.CurrentLocationUiState
import website.tachi.app.presentation.state.ScheduleUiState
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(private val scheduleUseCase: GetScheduleUseCase) :
    BaseViewModel() {

    private val _schedule = MutableStateFlow<ScheduleUiState>(ScheduleUiState.Loading)
    val schedule: StateFlow<ScheduleUiState> = _schedule.asStateFlow()

    fun loadSchedule(
        preferenceId: String?,
        festivalId: String?,
        keywordId: String?,
        travelDuration: String,
        latitude: Double,
        longitude: Double
    ) {
        viewModelScope.launch {
            kotlin.runCatching {
                scheduleUseCase.invoke(
                    preferenceId,
                    festivalId,
                    keywordId,
                    travelDuration,
                    latitude,
                    longitude
                )
            }.onSuccess { list ->
                _schedule.update {
                    ScheduleUiState.Success(list)
                }
            }.onFailure {
                Log.d("loadSchedule", it.message ?: "")
            }
        }
    }
}