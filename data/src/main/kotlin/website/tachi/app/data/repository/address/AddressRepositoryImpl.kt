package website.tachi.app.data.repository.address

import website.tachi.app.data.datasource.address.AddressDataSource
import website.tachi.app.data.datasource.address.AddressDataSourceImpl
import website.tachi.app.domain.repository.AddressRepository
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(private val addressDataSource: AddressDataSource) :
    AddressRepository {
    override suspend fun getAddress(latitude: Double, longitude: Double): String {
        return addressDataSource.getAddress(latitude, longitude)
    }
}