@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package app.feature.service

import app.feature.Book
import app.feature.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class BookService{
    @Autowired
    private lateinit var repository: BookRepository
    @PostConstruct
    fun init(){
        repository.save(Book(pages = 900, name = "book1"))
        repository.save(Book(pages = 902, name = "book2"))
    }

    fun findAll(): Any? {
        return repository.findAll();
    }

    fun save(book: Book) {
       repository.save(book)
    }

    fun update(book: Book){
        val bookById = repository.findById(book.id).get()
        bookById.name = book.name
        bookById.pages = book.pages
        repository.save(bookById)
    }
}