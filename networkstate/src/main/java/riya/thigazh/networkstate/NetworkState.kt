package riya.thigazh.networkstate

import kotlinx.coroutines.flow.StateFlow

enum class NetworkState {
    CONNECTING, CONNECTED, DISCONNECTED
}