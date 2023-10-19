package website.tachi.app.domain.usecase

import website.tachi.app.domain.model.Address
import website.tachi.app.domain.repository.AddressRepository
import website.tachi.app.domain.repository.LocationRepository
import java.lang.Exception
import javax.inject.Inject

class GetLastAddressUseCase @Inject constructor(
    private val getLastLocationRepository: LocationRepository,
    private val addressRepository: AddressRepository
) {
    operator suspend fun invoke(): Address {
        val lastCoord = getLastLocationRepository.getCurrentLocation()
        try {
            val address = addressRepository.getAddress(lastCoord.first, lastCoord.second)
            return Address(address, lastCoord.first, lastCoord.second)
        }catch ( e : Exception) {
            return Address("주소 정보 없음", lastCoord.first, lastCoord.second)
        }
    }
}