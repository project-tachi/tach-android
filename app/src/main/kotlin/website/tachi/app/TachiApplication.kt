package website.tachi.app

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TachiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_OAUTH_HOST_SCHEME)
        FirebaseApp.initializeApp(this)

        if (BuildConfig.DEBUG) {
            val keyHash = Utility.getKeyHash(this)
            Log.e("TachiApplication:Kakao", keyHash)
        }
    }
}