package website.tachi.app.presentation.ui.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import website.tachi.app.presentation.ui.main.MainScreen
import website.tachi.app.presentation.ui.search.SearchScreen
import website.tachi.app.presentation.ui.search.SearchViewModel

@Composable
fun TachiNavHost(navController: NavHostController = rememberNavController()) {
    val searchViewModel: SearchViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = TachiDestination.DESTINATION_MAIN) {
        composable(TachiDestination.DESTINATION_MAIN) {
            MainScreen(navController, searchViewModel)
        }
        composable(TachiDestination.DESTINATION_SEARCH) {
            SearchScreen(navController, searchViewModel)
        }
    }
}