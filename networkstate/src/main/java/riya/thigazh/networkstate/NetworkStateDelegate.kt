package riya.thigazh.networkstate

interface NetworkStateDelegate {
    suspend fun isNetworkConnected(): Boolean
}