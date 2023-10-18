package website.tachi.app.data.datasource.location

import kotlinx.coroutines.flow.Flow

interface LocationDataSource {
    suspend fun getCurrentLocation(): Pair<Double, Double>
}