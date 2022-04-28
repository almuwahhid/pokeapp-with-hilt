package com.bobobox.poketest.resources.data.source.local.db

import android.app.Application
import androidx.room.Room
import com.bobobox.poketest.resources.data.source.local.db.dao.FavPokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DbManager {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): PokeDB {
        return Room.databaseBuilder(application, PokeDB::class.java, "pokemon")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFavPokemonDao(database: PokeDB): FavPokemonDao {
        return  database.favPOkemonDao
    }
}