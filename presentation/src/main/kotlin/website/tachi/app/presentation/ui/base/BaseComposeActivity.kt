package com.meokq.boss.presentation.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import website.tachi.app.presentation.theme.AppTheme

abstract class BaseComposeActivity<R : BaseViewModel> : ComponentActivity() {

    abstract val viewModel: R

    abstract fun beforeCompose()

    @Composable
    abstract fun Compose()

    abstract fun afterCompose()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeCompose()
        setContent {
            AppTheme {
                Compose()
            }
        }
        afterCompose()
    }
}