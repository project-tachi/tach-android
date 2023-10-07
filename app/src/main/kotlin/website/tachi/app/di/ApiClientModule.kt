package website.tachi.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import website.tachi.app.data.network.TachiApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    @Provides
    @Singleton
    fun provideTachiApiService(): TachiApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.tachi.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(TachiApiService::class.java)
    }
}