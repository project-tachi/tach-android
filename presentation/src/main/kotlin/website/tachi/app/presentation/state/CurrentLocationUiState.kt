package website.tachi.app.presentation.state

import website.tachi.app.domain.model.Address

sealed class CurrentLocationUiState {
    object Loading : CurrentLocationUiState()
    data class Success(val address: Address) : CurrentLocationUiState()

    object Failure : CurrentLocationUiState()
}