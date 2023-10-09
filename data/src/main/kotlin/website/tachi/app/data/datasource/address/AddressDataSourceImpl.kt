package website.tachi.app.data.datasource.address

import website.tachi.app.data.network.TachiApiService
import website.tachi.app.data.util.roundToTwoDecimalPlaces
import website.tachi.app.data.util.truncateToTwoDecimalPlaces
import javax.inject.Inject

class AddressDataSourceImpl @Inject constructor(private val tachiApiService: TachiApiService) :
    AddressDataSource {
    override suspend fun getAddress(latitude: Double, longitude: Double): String {
        return tachiApiService.searchAddressByCoordinates(latitude.truncateToTwoDecimalPlaces(), longitude.truncateToTwoDecimalPlaces()).data!!
    }
}