package invoice.repository;

import invoice.domain.Phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "phone", path = "phone")
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
