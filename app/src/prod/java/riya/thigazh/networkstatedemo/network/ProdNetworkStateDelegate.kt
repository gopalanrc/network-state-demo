package riya.thigazh.networkstatedemo.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import riya.thigazh.networkstate.NetworkStateDelegate
import javax.inject.Inject

class ProdNetworkStateDelegate @Inject constructor(@ApplicationContext private val context: Context) : NetworkStateDelegate {
    override suspend fun isNetworkConnected(): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connMgr.getNetworkCapabilities(connMgr.activeNetwork)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
}