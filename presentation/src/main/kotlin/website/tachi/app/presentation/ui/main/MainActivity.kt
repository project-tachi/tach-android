package website.tachi.app.presentation.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kakao.sdk.user.UserApiClient
import com.meokq.boss.presentation.ui.base.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint
import website.tachi.app.presentation.theme.AppTheme
import website.tachi.app.presentation.ui.search.SearchScreen
import website.tachi.app.presentation.ui.sign.SignInScreen
import website.tachi.app.presentation.ui.sign.SignInViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : BaseComposeActivity<SignInViewModel>() {

    override val viewModel: SignInViewModel by viewModels()

    override fun beforeCompose() {
    }

    @Composable
    override fun Compose() {
        /*SignInScreen {
            UserApiClient.instance.loginWithKakaoTalk(this@MainActivity) { token, error ->
                if (error != null) {
                    Log.e("KakaoLoginState", "로그인 실패", error)
                } else if (token != null) {
                    Log.i("KakaoLoginState", "로그인 성공 ${token.accessToken}")
                }
            }
        }*/

        SearchScreen()
    }

    override fun afterCompose() {
    }
}