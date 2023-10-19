package website.tachi.app.presentation.state

import website.tachi.app.domain.model.Guide
import website.tachi.app.domain.model.Review
import website.tachi.app.domain.model.Spot

sealed class SpotUiState {
    object Loading : SpotUiState()
    data class Success(val spot: Spot, val review: List<Review>) : SpotUiState()

    object Failure : SpotUiState()
}