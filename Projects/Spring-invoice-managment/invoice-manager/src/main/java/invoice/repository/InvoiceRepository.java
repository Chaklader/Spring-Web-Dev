package invoice.repository;

import invoice.domain.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "invoice", path = "invoice")
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
