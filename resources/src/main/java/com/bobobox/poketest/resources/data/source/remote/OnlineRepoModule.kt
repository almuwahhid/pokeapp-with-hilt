package com.bobobox.poketest.resources.data.source.remote

import com.bobobox.poketest.resources.data.repository.OnlinePokeRepository
import com.bobobox.poketest.resources.data.source.remote.api.PokemonAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnlineRepoModule {

    @Singleton
    @Provides
    fun provideOnlinePokeRepository(
        pokemonAPI: PokemonAPI
    ): OnlinePokeRepository {
        return OnlinePokeRepository(pokemonAPI)
    }
}