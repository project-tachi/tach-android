package website.tachi.app.domain.repository

interface LocationRepository {
    suspend fun getCurrentLocation(): Pair<Double, Double>
}