package br.edu.infnet.Quotation.service;

import br.edu.infnet.Quotation.Model.Quotation;
import br.edu.infnet.Quotation.repository.IQuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    private final IQuotationRepository qr;

    @Autowired
    IQuotationRepository repository;

    public QuotationService(IQuotationRepository qr) {
        this.qr = qr;
    }

    public List<Quotation> ListarCotacoes(){
        return (List<Quotation>) repository.findAll();
    }

    public Quotation buscarCotacaoId(int quotationId) {
        return repository.findById((short) quotationId).get();
    }

    public Quotation BuscarCodigoProduto(int codProduct) {
        return repository.getByCodProduct(codProduct);
    }

    public Quotation save(Quotation quotation) {
        return repository.save(quotation);
    }

    public void delete(Integer quotationId) {
        repository.deleteByQuotationId(quotationId);
    }

    public List<Quotation> findAll() {
        return this.qr.findAll();
    }
}
