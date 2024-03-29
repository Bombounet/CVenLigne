package fr.cv

import javax.persistence.*

@Entity(name ="competences")
data class Competence(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var name: String?,
        @ManyToOne
        var user: User?){
        constructor() : this(null,null,null)
}