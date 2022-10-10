
package DevPortifolio.Mail.Controllers

import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired


import DevPortifolio.Mail.Entities.Email.Email
import DevPortifolio.Mail.Services.EmailService

@RestController
public class EmailController{
    @Autowired
    lateinit var service: EmailService

    @PostMapping("/email")
    fun sendEmail(@Valid @RequestBody email: Email){
        service.sendEmail(email.from,  email.to, email.subject, email.content)
      }
  }
