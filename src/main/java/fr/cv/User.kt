package fr.cv

/**
 *
 */
data class User(var firstName: String?, var lastName: String?, var birthMonth: Int?, var birthDay: Int?,
                var birthYear: Int?, var email: String?, var adresse: Adresse?,var phoneNumber: Int?,var experiences: List<Experience>?,
                var formations: List<Formation>?, var projets: List<Projet>?, var competences: List<String>?) {


}
