package website.tachi.app.presentation.ui.main

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.meokq.boss.presentation.ui.base.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint
import website.tachi.app.presentation.ui.search.SearchScreen
import website.tachi.app.presentation.ui.sign.SignInViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : BaseComposeActivity<SignInViewModel>() {

    override val viewModel: SignInViewModel by viewModels()

    override fun beforeCompose() {
    }

    @Composable
    override fun Compose() {
        SearchScreen()
    }

    override fun afterCompose() {
    }
}