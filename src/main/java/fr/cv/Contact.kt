package fr.cv

import javax.persistence.Embeddable

@Embeddable
data class Contact(var email: String?,
                   var phoneNumber: String?,
                   var address: String?,
                   var city: String?,
                   var postcode: Int?,
                   var country: String?) {

}
