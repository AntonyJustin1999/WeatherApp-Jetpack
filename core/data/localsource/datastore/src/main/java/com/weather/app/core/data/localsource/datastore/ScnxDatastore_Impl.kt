package com.weather.app.core.data.localsource.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ScnxDatastore_Impl @Inject
constructor (@ApplicationContext private val context: Context): ScnxDatastore {
    private val Context.dataStore by preferencesDataStore(name = "setting")

    override suspend fun save(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { preference->
            preference[key] = value
        }
    }

    override suspend fun read(key: Preferences.Key<String>): Flow<String> = context.dataStore.data
        .catch {
            if(this is Exception){
                emit(emptyPreferences())
            }
        }
        .map { preference->
            val value = preference[key] ?: ""
            value
        }

    override suspend fun remove(key: Preferences.Key<String>){
        context.dataStore.edit {
            it.remove(key)
        }
    }
}