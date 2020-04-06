import app.EnversCompareApp
import app.feature.Book
import com.google.gson.Gson
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = [EnversCompareApp::class])
class RestTest {
    private val gson: Gson = Gson()
    private val restTemplate: RestTemplate = RestTemplate()
    private val headers = HttpHeaders()

    @LocalServerPort
    var port = 8080

    @BeforeEach
    fun before() {
        headers.contentType = MediaType.APPLICATION_JSON;
    }

    @Test
    fun addTwoBooks() {
        val book: Book = Book(pages = 300, name = "hobbit")
        val book2: Book = Book(pages = 302, name = "Lord of the rings")
        val request: HttpEntity<String> = HttpEntity<String>(gson.toJson(book), headers)
        val request2: HttpEntity<String> = HttpEntity<String>(gson.toJson(book2), headers)
        restTemplate.postForObject("http://localhost:$port/book/save", request, String::class.java)
        restTemplate.postForObject("http://localhost:$port/book/save", request2, String::class.java)
    }

    @Test
    fun updateTwoBooks() {
        val book: Book = Book(id = 1, pages = 300, name = "updated hobbit")
        val book2: Book = Book(id = 2, pages = 302, name = "updated Lord of the rings")
        val request: HttpEntity<String> = HttpEntity<String>(gson.toJson(book), headers)
        val request2: HttpEntity<String> = HttpEntity<String>(gson.toJson(book2), headers)
        restTemplate.put("http://localhost:$port/book/update", request, String::class.java)
        restTemplate.put("http://localhost:$port/book/update", request2, String::class.java)
    }
}



