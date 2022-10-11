package DevPortifolio.Mail.Entities

import javax.persistence.*
import javax.validation.constraints.*;


@Entity
@Table(name = "contratante")
class Contractor(
   @Column(unique=true, name ="id")
   @field:Id
   @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,

    @field:NotNull
    @field:Size(min = 1, max =50)
    var name: String,

   @Column(unique=true, name="email")
    @field:NotNull
    @field:Email
    var email:String

){
  //  constructor(): this(-1,"", "")

      }

