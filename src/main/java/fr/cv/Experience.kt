package fr.cv

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name ="experiences")
data class Experience(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var name: String?,
        var year: String?,
        var place: String?,
        var description: String? ){

        constructor() : this(null,null,null,null,null)

}
