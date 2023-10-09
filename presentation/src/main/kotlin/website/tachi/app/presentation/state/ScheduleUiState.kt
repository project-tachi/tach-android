package website.tachi.app.presentation.state

import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.model.Preference
import website.tachi.app.domain.model.SchedulePlace

sealed class ScheduleUiState {
    object Loading : ScheduleUiState()
    data class Success(val places : List<SchedulePlace>) :
        ScheduleUiState()

    object Failure : ScheduleUiState()
}