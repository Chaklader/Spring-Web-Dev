package invoice.repository;

import invoice.domain.Adress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "adress", path = "adress")
public interface AdressRepository extends JpaRepository<Adress, Long> {

}
