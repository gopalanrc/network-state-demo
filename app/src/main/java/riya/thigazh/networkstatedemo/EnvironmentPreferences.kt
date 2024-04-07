package riya.thigazh.networkstatedemo

import riya.thigazh.networkstate.NetworkStateDelegate

interface EnvironmentPreferences {
    val networkStateDelegate: NetworkStateDelegate
}