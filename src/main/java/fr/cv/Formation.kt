package fr.cv

import javax.persistence.*

@Entity(name ="formations")
data class Formation(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var name: String?,
        var year: String?,
        var place: String?,
        var description: String?){
        constructor() : this(null,null,null,null,null)
}
