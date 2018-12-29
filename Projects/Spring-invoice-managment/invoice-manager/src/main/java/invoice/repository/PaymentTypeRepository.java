package invoice.repository;

import invoice.domain.PaymentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "paymentType", path = "paymentType")
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

}
