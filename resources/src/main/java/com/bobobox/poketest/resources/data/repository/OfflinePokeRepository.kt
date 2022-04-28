package com.bobobox.poketest.resources.data.repository

import com.bobobox.poketest.resources.data.entity.FavPokemon
import com.bobobox.poketest.resources.data.entity.Pokemon
import com.bobobox.poketest.resources.data.source.local.db.dao.FavPokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfflinePokeRepository @Inject constructor(val favPokemon : FavPokemonDao) : IOfflinePokeRepository{

    override suspend fun addFavoriteMonster(pokemon: FavPokemon) = withContext(Dispatchers.IO) {
        return@withContext favPokemon.add(pokemon)
    }

    override suspend fun removeFavoriteMonster(pokemon: FavPokemon) = withContext(Dispatchers.IO) {
        return@withContext favPokemon.remove(pokemon.id)
    }

    override suspend fun getFavoriteMonsters(): List<FavPokemon> = withContext(Dispatchers.IO) {
        return@withContext favPokemon.get()
    }

    override suspend fun isMonsterFavorited(id: Int): Boolean = withContext(Dispatchers.IO) {
        return@withContext favPokemon.isExist(id)
    }

}

interface IOfflinePokeRepository{
    suspend fun addFavoriteMonster(pokemon: FavPokemon) : Long
    suspend fun removeFavoriteMonster(pokemon: FavPokemon) : Int
    suspend fun getFavoriteMonsters() : List<FavPokemon>
    suspend fun isMonsterFavorited(id : Int) : Boolean
}