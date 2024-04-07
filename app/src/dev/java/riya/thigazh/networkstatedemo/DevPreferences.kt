package riya.thigazh.networkstatedemo

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import riya.thigazh.networkstate.NetworkStateDelegate
import riya.thigazh.networkstatedemo.network.DevNetworkStateDelegate

class DevPreferences : EnvironmentPreferences {
    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface DevPrefEntryPoint {
        fun devNetworkStateDelegate(): DevNetworkStateDelegate
    }

    override val networkStateDelegate: NetworkStateDelegate
        get() {
            val devPrefEntryPoint = EntryPointAccessors.fromApplication(NetworkStateDemoApp.instance, DevPrefEntryPoint::class.java)
            return devPrefEntryPoint.devNetworkStateDelegate()
        }
}