package fr.cv

import javax.persistence.*

/**
 *
 */
@Entity

data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var firstName: String?,
        var lastName: String?,
        var birthMonth: Int?,
        var birthDay: Int?,
        var birthYear: Int?,
        var email: String?,

        @Embedded
        var adresse: Adresse?,

        var phoneNumber: Int?,

        @OneToMany
        var experiences: List<Experience>?,

        @OneToMany
        var formations: List<Formation>?,

        @OneToMany
        var projets: List<Projet>?,

        @ManyToMany
        var competences: List<String>?) {


}
