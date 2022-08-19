package com.oganbelema.hellocomposeiv.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.IOException

data class Movie(
    @SerializedName("imdbID") val id: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Genre") val genre: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Actors") val actors: String,
    @SerializedName("Plot") val plot: String,
    @SerializedName("Poster") val poster: String,
    @SerializedName("imdbRating") val rating: String
)

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
