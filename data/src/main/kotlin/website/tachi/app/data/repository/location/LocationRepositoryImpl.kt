package website.tachi.app.data.repository.location

import website.tachi.app.data.datasource.location.LocationDataSource
import website.tachi.app.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(val locationDataSource: LocationDataSource) :
    LocationRepository {
    override suspend fun getCurrentLocation(): Pair<Double, Double> {
        return locationDataSource.getCurrentLocation()
    }
}