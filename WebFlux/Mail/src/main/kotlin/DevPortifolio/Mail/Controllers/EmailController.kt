
package DevPortifolio.Mail.Controllers

import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired


import DevPortifolio.Mail.Entities.Email.Email
import DevPortifolio.Mail.Services.EmailService
import DevPortifolio.Mail.Entities.Email.EmailToAll

@RestController
public class EmailController{
    @Autowired
    lateinit var service: EmailService


    @PostMapping("/email")
    fun sendEmail(@Valid @RequestBody email: Email){
        service.sendEmail(email.from,  email.to, email.subject, email.content)
      }

    //@PostMapping("/sendToAll")
    // Implamentar com chamada getAllUser no graphql
    /** fun sendToAll(@Valid @RequestBody email: EmailToAll){
    * var results =  em.createNativeQuery(""" SELECT email FROM contratante """).getResultList()
    * var i = 0 
    * results.forEach(){
    *    service.sendEmail(email.from, results.get(i).toString(), email.subject, email.content)
    *    i++
    *  }
    }**/
  }
