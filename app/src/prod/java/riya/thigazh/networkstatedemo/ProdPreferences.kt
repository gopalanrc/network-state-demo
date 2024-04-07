package riya.thigazh.networkstatedemo

import riya.thigazh.networkstate.NetworkStateDelegate
import riya.thigazh.networkstatedemo.network.ProdNetworkStateDelegate

class ProdPreferences : EnvironmentPreferences {
    override val networkStateDelegate: NetworkStateDelegate
        get() = ProdNetworkStateDelegate(NetworkStateDemoApp.instance.applicationContext)
}