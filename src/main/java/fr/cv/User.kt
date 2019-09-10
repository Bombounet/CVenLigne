package fr.cv

/**
 *
 */
data class User(var firstName: String?, var lastName: String?, var age: Int?) {
    constructor() : this(null, null, null)

}
