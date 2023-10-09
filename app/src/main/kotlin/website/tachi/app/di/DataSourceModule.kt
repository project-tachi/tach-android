package website.tachi.app.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import website.tachi.app.data.datasource.auth.AuthDataSource
import website.tachi.app.data.datasource.auth.AuthDataSourceImpl
import website.tachi.app.data.datasource.auth.AuthTokenDataSource
import website.tachi.app.data.datasource.auth.AuthTokenDataSourceImpl
import website.tachi.app.data.datasource.festival.FestivalDataSource
import website.tachi.app.data.datasource.festival.FestivalDataSourceImpl
import website.tachi.app.data.datasource.keyword.KeywordDataSource
import website.tachi.app.data.datasource.keyword.KeywordDataSourceImpl
import website.tachi.app.data.datasource.location.LocationDataSource
import website.tachi.app.data.datasource.location.LocationDataSourceImpl
import website.tachi.app.data.datasource.preference.SearchPreferenceDataSource
import website.tachi.app.data.datasource.preference.SearchPreferenceDataSourceImpl
import website.tachi.app.data.network.model.FestivalData
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindAuthDataSource(source: AuthDataSourceImpl): AuthDataSource

    @Binds
    @Singleton
    abstract fun bindAuthTokenDataSource(source: AuthTokenDataSourceImpl): AuthTokenDataSource

    @Binds
    @Singleton
    abstract fun bindFestivalDataSource(source: FestivalDataSourceImpl): FestivalDataSource

    @Binds
    @Singleton
    abstract fun bindKeywordDataSource(source: KeywordDataSourceImpl): KeywordDataSource

    @Binds
    @Singleton
    abstract fun bindPreferenceDataSource(source: SearchPreferenceDataSourceImpl): SearchPreferenceDataSource

    @Binds
    @Singleton
    abstract fun bindLocationDataSource(source: LocationDataSourceImpl): LocationDataSource
}