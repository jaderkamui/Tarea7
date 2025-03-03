package wallet.jader_munoz_marzo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object BitcoinService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://mindicador.cl/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: Api = retrofit.create(Api::class.java)

    interface Api {
        @GET("bitcoin")
        suspend fun getBitcoinData(): BitcoinResponse
    }
}

data class BitcoinResponse(
    val serie: List<BitcoinData>
)