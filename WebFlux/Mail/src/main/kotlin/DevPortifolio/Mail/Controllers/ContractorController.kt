
package DevPortifolio.Mail.Controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import DevPortifolio.Mail.Repositories.ContractorRepository

@RestController
@RequestMapping(...value, "/contractors")
class ContractorController{
   
    @Autowired
    lateinit var repository: ContractorRepository
  }
