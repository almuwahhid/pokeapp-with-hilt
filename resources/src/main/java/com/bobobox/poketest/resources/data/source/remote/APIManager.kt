package com.bobobox.poketest.resources.data.source.remote

import com.bobobox.poketest.resources.data.source.remote.api.PokemonAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIManager {

    @Singleton
    @Provides
    fun providePokemon(retrofit: Retrofit): PokemonAPI {
        return retrofit.create(PokemonAPI::class.java)
    }
}