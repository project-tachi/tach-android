package website.tachi.app.data.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun String.parseJsonToListOfString(): List<String> {
    val type = object : TypeToken<List<String>>() {}.type
    return Gson().fromJson(this, type)
}