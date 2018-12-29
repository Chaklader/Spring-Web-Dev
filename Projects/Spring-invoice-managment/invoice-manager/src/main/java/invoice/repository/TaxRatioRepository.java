package invoice.repository;

import invoice.domain.TaxRatio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "taxRatio", path = "taxRatio")
public interface TaxRatioRepository extends JpaRepository<TaxRatio, Integer> {

	
}
