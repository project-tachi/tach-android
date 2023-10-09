package website.tachi.app.presentation.state

import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.model.Preference

sealed class MainScreenUiState {
    object Loading : MainScreenUiState()
    data class Success(val festivals: List<Festival>, val preferences: List<Preference>, val keywords : List<Keyword>) :
        MainScreenUiState()

    object Failure : MainScreenUiState()
}