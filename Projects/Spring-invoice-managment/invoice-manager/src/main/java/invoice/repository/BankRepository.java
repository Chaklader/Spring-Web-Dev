package invoice.repository;

import invoice.domain.Bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bank", path = "bank")
public interface BankRepository extends JpaRepository<Bank, Long> {

}
