package br.com.monolit.tropicofunga.navigation.utils

import androidx.navigation.NavType
import androidx.savedstate.SavedState
import androidx.savedstate.read
import androidx.savedstate.write
import kotlin.uuid.Uuid

val UuidNavType = object : NavType<Uuid>(isNullableAllowed = false) {
    override fun put(
        bundle: SavedState,
        key: String,
        value: Uuid
    ) {
        bundle.write {
            putString(key, value.toString())
        }
    }

    override fun get(
        bundle: SavedState,
        key: String
    ): Uuid? {
        return bundle.read {
            getStringOrNull(key)?.let { Uuid.parse(it) }
        }
    }

    override fun parseValue(value: String): Uuid {
        return Uuid.parse(value)
    }

    override fun serializeAsValue(value: Uuid): String {
        return value.toString()
    }
}