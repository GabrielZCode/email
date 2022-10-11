
package DevPortifolio.Mail.Controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.NonUniqueResultException
import javax.persistence.Query
import javax.persistence.EntityManager
import DevPortifolio.Mail.Repositories.ContractorRepository
import DevPortifolio.Mail.Entities.Contractor
import javax.persistence.EntityNotFoundException
import com.sun.jdi.request.DuplicateRequestException
import java.util.regex.Pattern
import javax.validation.Valid

@RestController
@RequestMapping("/contractors")
class ContractorController(
  val em: EntityManager
){
   
    @Autowired
    lateinit var repository: ContractorRepository

    @GetMapping
    fun returnAll(): List<Contractor> {
          return repository.findAll()
      }

    @GetMapping("/{email}")
    fun getId(@Valid @PathVariable("email") email: String): Contractor{

      var contractor = Contractor(-1,"", "")
     var result: Long
      try{
      result = em.createNativeQuery(""" SELECT id FROM contratante WHERE email = ?1""").setParameter(1, email).setMaxResults(1).getSingleResult().toString().toLong()
      if(result.toString() ==""){
         return contractor.apply{
             this.name = "Error" ;
             this.email = " User not Registered"
           }
        }
      }catch(e: Exception){
          return contractor.apply{
             this.name= "Error" ;
             this.email = " User not Registered"
            }
        } 
        return contractor.apply { this.id = result ; this.email = email }
    }

   @PostMapping
   fun insert(@Valid @RequestBody contractor: Contractor): Contractor{ 
      try{
        if(Pattern.compile(
    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
  ).matcher(contractor.email).matches()){
            repository.save(contractor)
         } else{
          return contractor.apply{
                 this.name = "Error"
                 this.email = " Invalid Email"
             }
           }
        }catch(e: Exception){
          return contractor.apply{
                 this.name = "Error"+Exception(e)
                 this.email = " Duplicate Email"

             }
          }
        return contractor
    }


  @PostMapping("/update/{id}")
  fun Update(@Valid @PathVariable("id") id:Long, @Valid @RequestBody contractor: Contractor): Contractor{
       var tmp = repository.findById(id).orElseThrow{ EntityNotFoundException()}
       if(tmp == contractor){
           return contractor
         }
        if( tmp !== contractor){
            tmp.apply{
                this.name = contractor.name
              }
              repository.save(tmp)
            return tmp
          }
      return tmp 
    }

  @PostMapping("/{email}")
  fun delete(@Valid @PathVariable("email") email:String): Boolean{
    var result: Long
    try{
     result = em.createNativeQuery(""" SELECT id FROM contratante WHERE email = ?1""").setParameter(1, email).setMaxResults(1).getSingleResult().toString().toLong()
      if(result.toString() ==""){
          throw NonUniqueResultException(0)
        }
    }catch(e: Exception){
        return false
      }
      val contractor = repository.findById(result).orElseThrow{ EntityNotFoundException()}
    repository.delete(contractor);
    return true
    }
}
