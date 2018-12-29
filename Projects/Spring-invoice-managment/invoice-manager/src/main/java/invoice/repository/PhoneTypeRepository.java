package invoice.repository;

import invoice.domain.PhoneType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "phoneType", path = "phoneType")
public interface PhoneTypeRepository extends JpaRepository<PhoneType, Long> {

}
