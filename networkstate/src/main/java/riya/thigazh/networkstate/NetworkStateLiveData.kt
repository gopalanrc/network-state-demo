package riya.thigazh.networkstate

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NetworkStateLiveData(private val context: Context, private val networkStateDelegate: NetworkStateDelegate) : LiveData<NetworkState>() {
    companion object {
        private const val TAG = "NetworkStateLiveData"
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {

        override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
            Log.d(TAG, "onCapabilitiesChanged: network = $network")
            determineNetworkState()
        }

        override fun onLost(network: Network) {
            Log.d(TAG, "onLost: network = $network")
            postValue(NetworkState.DISCONNECTED)
        }
    }

    init {
        monitorNetwork()
    }

    override fun postValue(value: NetworkState?) {
        Log.d(TAG, "postValue: $value")
        super.postValue(value)
    }

    private fun determineNetworkState() = GlobalScope.launch(Dispatchers.Main) {
        postValue(NetworkState.CONNECTING)
        if (networkStateDelegate.isNetworkConnected()) {
            postValue(NetworkState.CONNECTED)
        } else {
            postValue(NetworkState.DISCONNECTED)
        }
    }

    private fun monitorNetwork() {
        val connectivityManager = context.getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        if (connectivityManager.activeNetwork == null) {
            postValue(NetworkState.DISCONNECTED)
        }
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

}