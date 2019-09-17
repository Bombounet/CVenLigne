package fr.cv

import javax.persistence.Embeddable

@Embeddable
data class Adresse(var adress: String?, var city: String?, var postcode: Int?, var country: String?) {

}
