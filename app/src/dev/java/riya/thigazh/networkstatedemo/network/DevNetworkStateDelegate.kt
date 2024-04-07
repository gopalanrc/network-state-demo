package riya.thigazh.networkstatedemo.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import riya.thigazh.networkstate.NetworkStateDelegate
import java.net.HttpURLConnection
import java.net.HttpURLConnection.HTTP_OK
import java.net.URL
import javax.inject.Inject

class DevNetworkStateDelegate @Inject constructor() : NetworkStateDelegate {

    companion object {
        private const val TAG = "DevNetworkStateDelegate"
    }

    override suspend fun isNetworkConnected(): Boolean = withContext(Dispatchers.IO) {
        try {
            val url = URL("https://google.com") // TODO replace it with your dev environment base url
            val connection = url.openConnection() as? HttpURLConnection
            connection?.responseCode == HTTP_OK
        } catch (e: Exception) {
            Log.d(TAG, "Unable to connect", e)
            false
        }
    }
}