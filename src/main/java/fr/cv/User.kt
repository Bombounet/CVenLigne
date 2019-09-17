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
        var email: String?,
        var bio: String?,

        @Embedded
        var adresse: Adresse?,

        var phoneNumber: Int?,

        @OneToMany(mappedBy="user")
        var experiences: List<Experience>?,

        @OneToMany(mappedBy="user")
        var formations: List<Formation>?,

        @OneToMany(mappedBy="user")
        var projets: List<Projet>?,

        @ManyToMany
        @JoinTable( name = "users_competences",
                joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "competences_id", referencedColumnName = "id")))
        var competences: List<Competence>?) {


        constructor() : this(null, null,null,null,null,null,null,null,null,null,null,null,null,null)

}
