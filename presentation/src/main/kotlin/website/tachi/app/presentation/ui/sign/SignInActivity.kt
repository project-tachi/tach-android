package website.tachi.app.presentation.ui.sign

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.kakao.sdk.user.UserApiClient
import com.meokq.boss.presentation.ui.base.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint
import website.tachi.app.presentation.ui.search.SearchScreen
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity @Inject constructor() : BaseComposeActivity<SignInViewModel>() {

    override val viewModel: SignInViewModel by viewModels()

    override fun beforeCompose() {
    }

    @Composable
    override fun Compose() {
        SignInScreen {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Log.e("KakaoLoginState", "로그인 실패", error)
                } else if (token != null) {
                    viewModel.signInWithKakao(token.accessToken)
                    Log.i("KakaoLoginState", "로그인 성공 ${token.accessToken}")
                }
            }
        }
    }

    override fun afterCompose() {
    }
}