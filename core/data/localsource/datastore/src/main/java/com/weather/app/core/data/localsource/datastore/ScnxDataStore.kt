package com.weather.app.core.data.localsource.datastore

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

interface ScnxDatastore {
    suspend fun save(key: Preferences.Key<String>, value:String)
    suspend fun read(key: Preferences.Key<String>) : Flow<String>
    suspend fun remove(key: Preferences.Key<String>)
}

object ScnxDatastoreKeys {
    val deviceId = stringPreferencesKey("deviceId")
    val accessToken = stringPreferencesKey("accessToken")
    val refreshToken = stringPreferencesKey("refreshToken")
    val expiresIn = stringPreferencesKey("expiresIn")
    val clientAccessToken = stringPreferencesKey("clientAccessToken")
    val clientRefreshToken = stringPreferencesKey("clientRefreshToken")
    val userId = stringPreferencesKey("userId")
    val dbRevision = stringPreferencesKey("dbRevision")
    val isFirstEverSynced = stringPreferencesKey("isFirstEverSynced")
    val isSyncing = stringPreferencesKey("isSyncing")
    val appEnvironmentUrl = stringPreferencesKey("appEnvironmentUrl")
    val findScannerRange = stringPreferencesKey("findScannerRange")
    val dbUpdatedDate = stringPreferencesKey("dbUpdatedDate")
    val checkInScannerRange = stringPreferencesKey("checkInScannerRange")
    val reconciliationScannerRange = stringPreferencesKey("reconciliationScannerRange")
    val programLocationScannerRange = stringPreferencesKey("programLocationScannerRange")
    val featureToggle = stringPreferencesKey("feature-toggle")
    val hasPoGrGd = stringPreferencesKey("hasPoGrGd")
    val hasWorkOrder = stringPreferencesKey("hasWorkOrder")
    val hasErpRobWritebackEnable = stringPreferencesKey("hasErpRobWritebackEnable")

}