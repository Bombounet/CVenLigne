package experiencesfr.cv

import com.fasterxml.jackson.annotation.JsonIgnore
import fr.cv.User
import javax.persistence.*

@Entity(name ="")
data class Experience(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var name: String?,
        var year: String?,
        var place: String?,
        var description: String?,
        @ManyToOne
        var user: User?){
        constructor() : this(null,null,null,null,null, null)

}
