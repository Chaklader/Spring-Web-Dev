package invoice.repository;

import invoice.domain.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")	
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
