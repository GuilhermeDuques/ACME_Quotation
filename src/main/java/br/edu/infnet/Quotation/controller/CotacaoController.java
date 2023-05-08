package br.edu.infnet.Quotation.controller;

import br.edu.infnet.Quotation.Model.Product;
import br.edu.infnet.Quotation.Model.Quotation;
import br.edu.infnet.Quotation.client.Produto_Id;
import br.edu.infnet.Quotation.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CotacaoController {

    @Autowired
    private QuotationService quotationService;

    @Autowired
    private Produto_Id produtoId;

    @RequestMapping(value = "/registrarCotacao", method = RequestMethod.POST)
    public String registerQuotation(@RequestParam double productPrice, @RequestParam int codProduct, @RequestParam int quotationId) {
        Quotation quotation;
        Product product;

        try {
            product = produtoId.getById(quotationId);
        } catch (Exception error) {
            return "Product não encontrado: "+error;
        }
        quotation = quotationService.buscarCotacaoId(codProduct);
        if (quotation != null) {
            return "A cotação já existe";
        }
        quotation = new Quotation((short) productPrice);
        try {
            quotationService.save(quotation);
        } catch (Exception error) {
            return " Erro inesperado ao criar uma cotação: "+error;
        }
        return "Contação criada com sucesso!!! ";
    }

   @RequestMapping(value = "/cotacoes", method = RequestMethod.GET)
   public List<Quotation> all(){
       return quotationService.findAll();
    }

    @RequestMapping(value = "/cotacao/{cotacaoId}", method = RequestMethod.GET)
    public String bucarProdutoPorId(@PathVariable Integer quotationId) {
        Product product;

       try {
           Produto_Id productService = null;
           product = productService.getById(quotationId);
        } catch (Exception e) {
            return "Product não encontrado";
        }
       return " Resposta: "+product;
    }

   @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
   public String deleteProduct(@PathVariable Integer quotationId) {
       Quotation quotation;

       QuotationService productService = null;
       try {
            quotation = productService.buscarCotacaoId(quotationId);
       } catch (Exception e) {
            return "Product não encontrado";
        }
        try {
           productService.delete(quotationId);
       } catch (Exception error) {
            return "Erro inesperado ao excluir um produto: "+error;
        }
        return "Produto deletetado com sucesso!!!";
   }
}
