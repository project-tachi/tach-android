package website.tachi.app.domain.usecase

import website.tachi.app.domain.repository.LocationRepository
import javax.inject.Inject

class GetLastLocationUseCase @Inject constructor(private val getLastLocationRepository: LocationRepository) {
    operator suspend fun invoke() : Pair<Double, Double> {
        return getLastLocationRepository.getCurrentLocation()
    }
}