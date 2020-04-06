package app.feature

import app.feature.service.Parent
import com.google.gson.Gson
import org.springframework.http.HttpEntity
import org.springframework.web.client.RestTemplate

open class RunRestTemplate : Parent() {
    private val gson: Gson = Gson()
    private val restTemplate: RestTemplate = RestTemplate()
    fun init() {
        addTwoBooks()
        updateTwoBooks()
    }


    fun addTwoBooks() {
        val book: Book = Book(pages = 300, name = "hobbit")
        val book2: Book = Book(pages = 302, name = "Lord of the rings")
        val request: HttpEntity<String> = HttpEntity<String>(gson.toJson(book), headers)
        val request2: HttpEntity<String> = HttpEntity<String>(gson.toJson(book2), headers)
        print("value port -> $port")
        val destination = "http://localhost:$port/book/save"
        restTemplate.postForObject(destination, request, String::class.java)
        restTemplate.postForObject(destination, request2, String::class.java)
    }


    fun updateTwoBooks() {
        val book: Book = Book(id = 1, pages = 300, name = "updated hobbit")
        val book2: Book = Book(id = 2, pages = 302, name = "updated Lord of the rings")
        val request: HttpEntity<String> = HttpEntity<String>(gson.toJson(book), headers)
        val request2: HttpEntity<String> = HttpEntity<String>(gson.toJson(book2), headers)
        restTemplate.put("http://localhost:$port/book/update", request, String::class.java)
        restTemplate.put("http://localhost:$port/book/update", request2, String::class.java)
    }
}

fun main() {
    val runRest: RunRestTemplate = RunRestTemplate()
    runRest.init()

}