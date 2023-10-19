package website.tachi.app.presentation.state

import website.tachi.app.domain.model.Festival
import website.tachi.app.domain.model.Keyword
import website.tachi.app.domain.model.Preference

sealed class MainBackgroundImageUrlUiState {
    object Loading : MainBackgroundImageUrlUiState()
    data class Success(val url: String) :
        MainBackgroundImageUrlUiState()

    object Failure : MainBackgroundImageUrlUiState()
}