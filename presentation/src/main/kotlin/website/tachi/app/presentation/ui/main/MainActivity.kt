package website.tachi.app.presentation.ui.main

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.meokq.boss.presentation.ui.base.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint
import website.tachi.app.presentation.ui.nav.TachiNavHost
import website.tachi.app.presentation.ui.search.SearchViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : BaseComposeActivity<SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    override fun beforeCompose() {
    }

    @Composable
    override fun Compose() {
        val navController = rememberNavController()

        TachiNavHost(navController = navController)
    }

    override fun afterCompose() {
    }
}