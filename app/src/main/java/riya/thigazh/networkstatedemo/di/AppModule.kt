package riya.thigazh.networkstatedemo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import riya.thigazh.networkstate.NetworkStateDelegate
import riya.thigazh.networkstate.NetworkStateLiveData
import riya.thigazh.networkstatedemo.BuildConfig
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideNetworkStateDelegate(): NetworkStateDelegate = BuildConfig.ENV_PREFERENCES.networkStateDelegate

    @Singleton
    @Provides
    fun provideNetworkStateLiveData(@ApplicationContext context: Context, networkStateDelegate: NetworkStateDelegate): NetworkStateLiveData =
        NetworkStateLiveData(context, networkStateDelegate)
}