
package DevPortifolio.Mail.Entities.Email

import org.hibernate.validator.constraints.NotEmpty


class Email(
    @field:NotEmpty
    val from: String,
    
    @field:NotEmpty
    val to:String,

    @field:NotEmpty
    val subject: String,

    @field:NotEmpty
    val content: String
)
