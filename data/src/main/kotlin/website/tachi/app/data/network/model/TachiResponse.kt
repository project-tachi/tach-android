package website.tachi.app.data.network.model

data class TachiResponse<T>(val success: Boolean, val data: T?, val error: TachiErrorResponse)

data class TachiErrorResponse(val code: String, val message: String)