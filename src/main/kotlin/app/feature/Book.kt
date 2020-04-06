package app.feature

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.envers.Audited

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Audited
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
class Book(
   @Id
   @GeneratedValue
   val id: Int?=null,
   var pages: Int?=null,
   var name: String?=null){

}


