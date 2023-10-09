package website.tachi.app.data.datasource.address

interface AddressDataSource {
    suspend fun getAddress(latitude : Double, longitude : Double) : String
}