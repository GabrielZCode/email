
package DevPortifolio.Mail.Services


import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.mail.javamail.JavaMailSender
import javax.mail.internet.MimeMessage

@Service
class EmailService{
     @Autowired
     lateinit var service: JavaMailSender 


    fun sendEmail(from: String, to: String, subject: String , content: String){
      val msg = service.createMimeMessage()
      val helper = MimeMessageHelper(msg, true)
      helper.setFrom(from)
      helper.setTo(to)
      helper.setSubject(subject)
      helper.setText(content, true)

      service.send(msg)
      }
      
      
  }
