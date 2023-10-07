package website.tachi.app.presentation.ui.sign

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.meokq.boss.presentation.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import website.tachi.app.domain.usecase.SignInWithKakaoUseCase
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInWithKakaoUseCase: SignInWithKakaoUseCase) :
    BaseViewModel() {

    fun signInWithKakao(kakaoAccessToken: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                signInWithKakaoUseCase(kakaoAccessToken)
            }.onSuccess {
                Log.d("signInWithKakao", it)
            }.onFailure {
                Log.e("signInWithKakao", it.message ?: "")
            }
        }
    }
}