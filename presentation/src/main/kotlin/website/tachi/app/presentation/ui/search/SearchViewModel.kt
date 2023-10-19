package website.tachi.app.presentation.ui.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.meokq.boss.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import website.tachi.app.domain.usecase.GetFestivalsUseCase
import website.tachi.app.domain.usecase.GetKeywordsUseCase
import website.tachi.app.domain.usecase.GetLastAddressUseCase
import website.tachi.app.domain.usecase.GetMainBackgroundImageUrl
import website.tachi.app.domain.usecase.GetPreferencesUseCase
import website.tachi.app.presentation.state.CurrentLocationUiState
import website.tachi.app.presentation.state.MainBackgroundImageUrlUiState
import website.tachi.app.presentation.state.MainScreenUiState
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getFestivalsUseCase: GetFestivalsUseCase,
    private val getPreferencesUseCase: GetPreferencesUseCase,
    private val getKeywordsUseCase: GetKeywordsUseCase,
    private val getLastAddressUseCase: GetLastAddressUseCase,
    private val getMainBackgroundImageUrl: GetMainBackgroundImageUrl
) : BaseViewModel() {

    private val _backgroundImageUrl =
        MutableStateFlow<MainBackgroundImageUrlUiState>(MainBackgroundImageUrlUiState.Loading)
    val backgroundImageUrl: StateFlow<MainBackgroundImageUrlUiState> =
        _backgroundImageUrl.asStateFlow()

    private val _conditions = MutableStateFlow<MainScreenUiState>(MainScreenUiState.Loading)
    val conditions: StateFlow<MainScreenUiState> = _conditions.asStateFlow()

    private val _location = MutableStateFlow<CurrentLocationUiState>(CurrentLocationUiState.Loading)
    val location: StateFlow<CurrentLocationUiState> = _location.asStateFlow()

    val selectPreferenceId = mutableStateOf<Int?>(null)
    var selectKeywordId = mutableStateOf<Int?>(null)
    var selectFestivalId = mutableStateOf<Long?>(null)

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                getMainBackgroundImageUrl()
            }.onSuccess { url ->
                Log.e("getMainBackgroundImageUrl", url)
                _backgroundImageUrl.update {
                    MainBackgroundImageUrlUiState.Success(url)
                }
            }.onFailure {
                Log.e("getMainBackgroundImageUrl", it.message ?: "")
            }
        }

        viewModelScope.launch {
            kotlin.runCatching {
                getLastAddressUseCase()
            }.onSuccess { address ->
                _location.update {
                    CurrentLocationUiState.Success(address)
                }
            }.onFailure {
                Log.e("getLastLocationUseCase", it.message ?: "")
            }
        }

        viewModelScope.launch {
            val preferenceFetch = async {
                getPreferencesUseCase()
            }

            val festivalFetch = async {
                getFestivalsUseCase().subList(0, 5)
            }

            val keywordFetch = async {
                getKeywordsUseCase()
            }

            _conditions.update {
                MainScreenUiState.Success(
                    festivalFetch.await(), preferenceFetch.await(), keywordFetch.await()
                )
            }
        }
    }
}