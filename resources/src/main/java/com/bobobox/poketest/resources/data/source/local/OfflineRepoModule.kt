package com.bobobox.poketest.resources.data.source.local

import android.app.Application
import androidx.room.Room
import com.bobobox.poketest.resources.data.repository.OfflinePokeRepository
import com.bobobox.poketest.resources.data.source.local.db.PokeDB
import com.bobobox.poketest.resources.data.source.local.db.dao.FavPokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OfflineRepoModule {

    @Singleton
    @Provides
    fun provideOfflinePokeRepository(
        favPokemon : FavPokemonDao
    ): OfflinePokeRepository {
        return OfflinePokeRepository(favPokemon)
    }
}