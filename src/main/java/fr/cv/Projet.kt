package fr.cv

import javax.persistence.*

@Entity(name ="projets")
data class Projet(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var name: String?,
        var year: String?,
        var place: String?,
        var description: String?
){

}
