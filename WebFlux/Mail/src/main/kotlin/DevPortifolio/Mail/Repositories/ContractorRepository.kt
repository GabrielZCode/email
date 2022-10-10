
package DevPortifolio.Mail.Repositories

import org.springframework.data.jpa.repository.JpaRepository
import DevPortifolio.Mail.Entities.Contractor
import org.springframework.stereotype.Repository
import javax.persistence.Query

@Repository
interface ContractorRepository :  JpaRepository<Contractor, Long>{ 
  }
