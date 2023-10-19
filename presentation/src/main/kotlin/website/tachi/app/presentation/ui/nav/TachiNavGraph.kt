package website.tachi.app.presentation.ui.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import website.tachi.app.presentation.ui.guide.GuideDetailScreen
import website.tachi.app.presentation.ui.main.MainScreen
import website.tachi.app.presentation.ui.schedule.ScheduleScreen
import website.tachi.app.presentation.ui.search.SearchScreen
import website.tachi.app.presentation.ui.search.SearchViewModel
import website.tachi.app.presentation.ui.spot.SpotDetailScreen

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
        composable("schedule/{preferenceId}/{festivalId}/{keywordId}/{travelDuration}/{latitude}/{longitude}") { backStackEntry ->
            val preferenceId =
                backStackEntry.arguments?.getString("preferenceId")?.takeIf { it != "unknown" }
            val festivalId =
                backStackEntry.arguments?.getString("festivalId")?.takeIf { it != "unknown" }
            val keywordId =
                backStackEntry.arguments?.getString("keywordId")?.takeIf { it != "unknown" }
            val travelDuration = backStackEntry.arguments?.getString("travelDuration")!!
            val latitude = backStackEntry.arguments?.getString("latitude")?.toDouble()!!
            val longitude = backStackEntry.arguments?.getString("longitude")?.toDouble()!!

            ScheduleScreen(
                navController = navController,
                preferenceId = preferenceId,
                festivalId = festivalId,
                keywordId = keywordId,
                travelDuration = travelDuration,
                latitude = latitude,
                longitude = longitude
            )
        }
        composable(TachiDestination.DESTINATION_GUIDE_DETAIL + "/{guideId}") {
            val guideId = it.arguments?.getString("guideId")?.takeIf { it != "unknown" }

            GuideDetailScreen(navController, guideId = guideId?.toLong() ?: -1)
        }

        composable(TachiDestination.DESTINATION_SPOT_DETAIL + "/{spotId}") {
            val spotId = it.arguments?.getString("spotId")?.takeIf { it != "unknown" }

            SpotDetailScreen(navController, spotId = spotId?.toLong() ?: -1)
        }
    }
}