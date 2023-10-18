package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Address
import website.tachi.app.domain.repository.AddressRepository
import website.tachi.app.domain.repository.LocationRepository
import javax.inject.Inject

class GetLastAddressUseCase @Inject constructor(
    private val getLastLocationRepository: LocationRepository,
    private val addressRepository: AddressRepository
) {
    operator suspend fun invoke(): Address {
        val lastCoord = getLastLocationRepository.getCurrentLocation()
        val address = addressRepository.getAddress(lastCoord.first, lastCoord.second)
        return Address(address, lastCoord.first, lastCoord.second)
    }
}