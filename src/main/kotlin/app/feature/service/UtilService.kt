package app.feature.service

import com.google.gson.Gson
import org.springframework.stereotype.Service

@Service
class UtilService {
    private val gson: Gson = Gson()

    fun toJson (obj: Any?):String{
        return gson.toJson(obj)
    }
}