package website.tachi.app.presentation.ui.spot

import androidx.lifecycle.viewModelScope
import com.meokq.boss.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import website.tachi.app.domain.usecase.GetGuideReviewsUseCase
import website.tachi.app.domain.usecase.GetGuideUseCase
import website.tachi.app.domain.usecase.GetSpotReviewsUseCase
import website.tachi.app.domain.usecase.GetSpotUseCase
import website.tachi.app.presentation.state.GuideUiState
import website.tachi.app.presentation.state.SpotUiState
import javax.inject.Inject

@HiltViewModel
class SpotDetailViewModel @Inject constructor(
    private val getSpotUseCase: GetSpotUseCase,
    private val getSpotReviewsUseCase: GetSpotReviewsUseCase
) : BaseViewModel() {

    private val _spot = MutableStateFlow<SpotUiState>(SpotUiState.Loading)
    val spot: StateFlow<SpotUiState> = _spot.asStateFlow()

    fun loadSpot(spotId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val spot = async {
                getSpotUseCase(spotId)
            }
            val reviews = async {
                getSpotReviewsUseCase(spotId)
            }

            _spot.update {
                SpotUiState.Success(spot.await(), reviews.await())
            }
        }
    }
}