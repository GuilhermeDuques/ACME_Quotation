package br.edu.infnet.Quotation.repository;


import br.edu.infnet.Quotation.Model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IQuotationRepository extends JpaRepository<Quotation, Short> {

    @Query(value="SELECT * FROM quotations WHERE quotationId = :quotationId", nativeQuery=true)

    Quotation getByCodProduct(int codProduct);

    void deleteByQuotationId(Integer quotationId);
}
