package riya.thigazh.networkstatedemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NetworkStateDemoApp : Application() {
    companion object {
        lateinit var instance: NetworkStateDemoApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}