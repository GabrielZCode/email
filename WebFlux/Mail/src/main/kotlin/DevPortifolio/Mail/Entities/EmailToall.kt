
package DevPortifolio.Mail.Entities.Email
import org.hibernate.validator.constraints.NotEmpty


class EmailToAll(
    @field:NotEmpty
    val from: String,
    

    @field:NotEmpty
    val subject: String,

    @field:NotEmpty
    val content: String
)
