package website.tachi.app.domain.repository

interface AddressRepository {
    suspend fun getAddress(latitude: Double, longitude: Double): String
}