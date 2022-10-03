package DevPortifolio.Mail.Entities

import javax.persistence.*
import javax.validation.constraints.*;

@Entity
@Table(name = "Contratante")
class Contractor(
   @field:Id
   @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,

    @field:NotNull
    @field:Size(min = 1, max =50)
    var name: String,

    @field:NotNull
    @field:Email
    var email:String

)
