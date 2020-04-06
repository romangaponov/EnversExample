package app.feature.service

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import java.io.BufferedReader

open class Parent {
    var port: String
    val headers = HttpHeaders()

    constructor() {
        headers.contentType = MediaType.APPLICATION_JSON;
        port = getByPropetyValue("server.port")
    }

    lateinit var content: LinkedHashSet<String>
    fun getByPropetyValue(path: String): String {
        content = getHashSetFromProperties()
        val split = path.split(".")
        var counter = 0
        content.forEach { elem ->
            if (elem.contains(split[counter])) {

            }
            if (split.size - counter == 1) {
                val splitByColumns = elem.split(":")
                return splitByColumns[1]
            }
            counter++
        }
        return ""
    }

    fun getHashSetFromProperties(): LinkedHashSet<String> {
        val content: LinkedHashSet<String> = LinkedHashSet<String>()
        val reader = BufferedReader(
            Thread
                .currentThread()
                .contextClassLoader
                .getResourceAsStream("application.yml").reader()
        )
        reader.use { reader ->
            var line = reader.readLine()
            while (line != null) {
                content.add(line)
                line = reader.readLine()
            }
        }
        return content
    }

}