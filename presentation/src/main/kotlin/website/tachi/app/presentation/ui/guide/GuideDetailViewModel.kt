package website.tachi.app.presentation.ui.guide

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
import website.tachi.app.presentation.state.GuideUiState
import website.tachi.app.presentation.state.ScheduleUiState
import javax.inject.Inject

@HiltViewModel
class GuideDetailViewModel @Inject constructor(
    private val getGuideUseCase: GetGuideUseCase,
    private val getGuideReviewsUseCase: GetGuideReviewsUseCase
) : BaseViewModel() {

    private val _guide = MutableStateFlow<GuideUiState>(GuideUiState.Loading)
    val guide: StateFlow<GuideUiState> = _guide.asStateFlow()

    fun loadGuide(guideId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val guide = async {
                getGuideUseCase(guideId)
            }
            val reviews = async {
                getGuideReviewsUseCase(guideId)
            }

            _guide.update {
                GuideUiState.Success(guide.await(), reviews.await())
            }
        }
    }
}