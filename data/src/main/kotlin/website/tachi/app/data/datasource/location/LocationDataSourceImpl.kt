package website.tachi.app.data.datasource.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationDataSourceImpl @Inject constructor(@ApplicationContext val context: Context) :
    LocationDataSource {
    override suspend fun getCurrentLocation(): Pair<Double, Double> {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            throw IllegalStateException("permission denied")
        }

        return suspendCancellableCoroutine { continuation ->
            LocationServices.getFusedLocationProviderClient(context).lastLocation
                .addOnSuccessListener { location: Location? ->
                    location?.let {
                        continuation.resume(Pair(it.latitude, it.longitude))
                    } ?: continuation.resumeWithException(
                        IllegalStateException("Location is null")
                    )
                }
                .addOnFailureListener {
                    continuation.resumeWithException(it)
                }
        }
    }
}