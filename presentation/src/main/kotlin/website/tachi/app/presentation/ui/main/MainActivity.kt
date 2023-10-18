package website.tachi.app.presentation.ui.main

import android.Manifest
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.meokq.boss.presentation.ui.base.BaseComposeActivity
import dagger.hilt.android.AndroidEntryPoint
import website.tachi.app.presentation.ui.nav.TachiNavHost
import website.tachi.app.presentation.ui.search.SearchViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : BaseComposeActivity<SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    var permissionGrant by mutableStateOf(false)

    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                permissionGrant = true
            }

            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                permissionGrant = true
            }

            else -> {
                permissionGrant = false
            }
        }
    }

    override fun beforeCompose() {

    }

    @Composable
    override fun Compose() {
        val navController = rememberNavController()

        if (permissionGrant)
            TachiNavHost(navController = navController)
        else
            Box(Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center).padding(16.dp),
                    text = "If you don't allow location permission, you won't be able to use the app.\n" +
                            "\n" +
                            "We are an application that recommends travel destinations based on your current location. The reasons why we need location permission are as follows.\n" +
                            "\n" +
                            "1. Location information is required because we recommend travel destination search options by selecting festival information and keywords based on your location.\n" +
                            "\n" +
                            "2. Location information is required because the nearest travel destination is recommended based on your location."
                )
            }
    }

    override fun afterCompose() {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
}