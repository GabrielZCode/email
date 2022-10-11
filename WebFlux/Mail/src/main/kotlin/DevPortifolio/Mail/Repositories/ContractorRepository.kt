
package DevPortifolio.Mail.Repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import DevPortifolio.Mail.Entities.Contractor
import org.springframework.stereotype.Repository
import javax.persistence.Query
import javax.persistence.EntityManager
@Repository
interface ContractorRepository :  JpaRepository<Contractor, Long>{ 
  }
