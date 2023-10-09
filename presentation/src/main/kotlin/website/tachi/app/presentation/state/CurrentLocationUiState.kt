package website.tachi.app.presentation.state

sealed class CurrentLocationUiState {
    object Loading : CurrentLocationUiState()
    data class Success(val latitude: Double, val longitude: Double) :
        CurrentLocationUiState()

    object Failure : CurrentLocationUiState()
}