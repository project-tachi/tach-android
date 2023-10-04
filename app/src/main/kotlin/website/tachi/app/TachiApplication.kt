package website.tachi.app

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class TachiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "{NATIVE_APP_KEY}")

    }
}