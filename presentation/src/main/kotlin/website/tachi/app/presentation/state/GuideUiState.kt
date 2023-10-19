package website.tachi.app.presentation.state

import website.tachi.app.domain.model.Guide
import website.tachi.app.domain.model.Review
import website.tachi.app.domain.model.ScheduleResponse

sealed class GuideUiState {
    object Loading : GuideUiState()
    data class Success(val guide: Guide, val review: List<Review>) : GuideUiState()

    object Failure : GuideUiState()
}