package invoice.repository;

import invoice.domain.ItemUnitOfMass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "itemUnitOfMass", path = "itemUnitOfMass")
public interface ItemUnitOfMassRepository extends JpaRepository<ItemUnitOfMass, Integer> {

}
