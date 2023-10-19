package website.tachi.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import website.tachi.app.data.repository.address.AddressRepositoryImpl
import website.tachi.app.data.repository.auth.AuthRepositoryImpl
import website.tachi.app.data.repository.auth.AuthTokenRepositoryImpl
import website.tachi.app.data.repository.festival.FestivalRepositoryImpl
import website.tachi.app.data.repository.guide.GuideRepositoryImpl
import website.tachi.app.data.repository.keyword.KeywordRepositoryImpl
import website.tachi.app.data.repository.location.LocationRepositoryImpl
import website.tachi.app.data.repository.mainbg.MainBackgroundImageRepositoryImpl
import website.tachi.app.data.repository.preference.PreferenceRepositoryImpl
import website.tachi.app.data.repository.review.ReviewRepositoryImpl
import website.tachi.app.data.repository.schedule.ScheduleRepositoryImpl
import website.tachi.app.data.repository.spot.SpotRepositoryImpl
import website.tachi.app.domain.repository.AddressRepository
import website.tachi.app.domain.repository.AuthRepository
import website.tachi.app.domain.repository.AuthTokenRepository
import website.tachi.app.domain.repository.FestivalRepository
import website.tachi.app.domain.repository.GuideRepository
import website.tachi.app.domain.repository.KeywordRepository
import website.tachi.app.domain.repository.LocationRepository
import website.tachi.app.domain.repository.MainBackgroundImageRepository
import website.tachi.app.domain.repository.PreferenceRepository
import website.tachi.app.domain.repository.ReviewRepository
import website.tachi.app.domain.repository.ScheduleRepository
import website.tachi.app.domain.repository.SpotRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(repo: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindAuthTokenRepository(repo: AuthTokenRepositoryImpl): AuthTokenRepository

    @Binds
    @Singleton
    abstract fun bindFestivalRepository(repo : FestivalRepositoryImpl) : FestivalRepository

    @Binds
    @Singleton
    abstract fun bindKeywordRepository(repo: KeywordRepositoryImpl) : KeywordRepository

    @Binds
    @Singleton
    abstract fun bindPreferenceRepository(repo : PreferenceRepositoryImpl) : PreferenceRepository

    @Binds
    @Singleton
    abstract fun bindLocationRepository(repo : LocationRepositoryImpl) : LocationRepository

    @Binds
    @Singleton
    abstract fun bindAddressRepository(repo : AddressRepositoryImpl) : AddressRepository

    @Binds
    @Singleton
    abstract fun bindScheduleRepository(repo : ScheduleRepositoryImpl) : ScheduleRepository

    @Binds
    @Singleton
    abstract fun bindGuideRepository(repo : GuideRepositoryImpl) : GuideRepository

    @Binds
    @Singleton
    abstract fun bindReviewRepository(repo : ReviewRepositoryImpl) : ReviewRepository

    @Binds
    @Singleton
    abstract fun bindSpotRepository(repo : SpotRepositoryImpl) :SpotRepository

    @Binds
    @Singleton
    abstract fun bindMainBackgroundImageRepository(repo : MainBackgroundImageRepositoryImpl) : MainBackgroundImageRepository
}