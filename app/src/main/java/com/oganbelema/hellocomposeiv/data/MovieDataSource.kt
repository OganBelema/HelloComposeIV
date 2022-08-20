package com.oganbelema.hellocomposeiv.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.oganbelema.hellocomposeiv.model.Movie
import java.io.IOException

class MovieDataSource {
    fun getMovies(context: Context): List<Movie> {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("movies.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }

        val listCountryType = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(jsonString, listCountryType)
    }
}