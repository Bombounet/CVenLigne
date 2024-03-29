package fr.cv

import javax.persistence.*

/**
 *
 */
@Entity(name ="users")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var firstName: String?,
        var lastName: String?,
        var birthMonth: Int?,
        var birthDay: Int?,
        var birthYear: Int?,
        var bio: String?,

        @Embedded
        var contact: Contact?,

        @OneToMany(mappedBy="user")
        var experiences: List<Experience>?,

        @OneToMany(mappedBy="user")
        var formations: List<Formation>?,

        @OneToMany(mappedBy="user")
        var projets: List<Projet>?,

        @OneToMany(mappedBy="user")
        var competences: List<Competence>?) {


        constructor() : this(null,null,null,null,null,null,null,null,null,null,null,null)

}
