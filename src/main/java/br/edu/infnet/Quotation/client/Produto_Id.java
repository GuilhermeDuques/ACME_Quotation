package br.edu.infnet.Quotation.client;

import br.edu.infnet.Quotation.Model.Product;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="http://localhost:8091", name = "ProdutoId")
@Headers("Content-Type: application/json")
public interface Produto_Id {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    Product getById(@RequestParam int productId);

}