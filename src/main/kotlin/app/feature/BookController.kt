package app.feature

import app.feature.service.BookService
import app.feature.service.UtilService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

private const val JSON = "application/json"
@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private lateinit var service: BookService
    @Autowired
    private lateinit var gson: UtilService

    @GetMapping("/getAll")
    fun getAll(): String {
        return gson.toJson(service.findAll())
    }
    @GetMapping("/hello")
    fun hello(): String {
        return "OK"
    }

    @PostMapping("/save", consumes = [JSON])
    fun saveBook(@RequestBody book: Book): String {
        service.save(book)
        return "OK"
    }

    @PutMapping("/update")
    fun updateBook(@RequestBody book: Book): String {
        service.update(book)
        return "OK"
    }
}