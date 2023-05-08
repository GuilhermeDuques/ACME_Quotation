package br.edu.infnet.Quotation.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable {

        private static final long serialVersionID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "product_id")
        private Short idProduto;
        @Basic(optional = false)
        @Column(name = "product_name")
        private String nomeProduto;
        @Basic(optional = false)
        @Column(name = "product_quantity")
        private String quantidadeProd;
        @Basic(optional = false)
        @Column(name = "product_image")
        private String imagemProd;
        @Column(unique=true)
        private int codProduct;
        @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Quotation> quotations = new HashSet<>();

        private int quotationId;

        public Product() {
        }

        private Product(Short productId) {
            this.idProduto = productId;
        }

        public Product(String nomeProduto, String quantidadeProd, String imagemProd, int codProduct) {
            this.nomeProduto = nomeProduto;
            this.quantidadeProd = quantidadeProd;
            this.imagemProd = imagemProd;
            this.codProduct = codProduct;
        }

        public Product(String nomeProduto, boolean b, Date time, int quotationId, int storeId) {
        }

        public Product(String nomeProduto, int quantidadeProd, int codProduct) {
        }

        public Short getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(Short idProduto) {
            this.idProduto = idProduto;
        }

        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public String getImagemProd() {
            return imagemProd;
        }

        public void setImagemProd(String imagemProd) {
            this.imagemProd = imagemProd;
        }

        public int getQuotationId() {
            return quotationId;
        }

        public int getCodProduct() {
            return codProduct;
        }

        public void setCode(int code) {
            this.codProduct = codProduct;
        }

        public void setQuotationId(int quotationId) {
            this.quotationId = quotationId;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Produto{id=").append(idProduto);
            sb.append(", img=").append(imagemProd);
            sb.append(", nome=").append(nomeProduto);
            sb.append(", quantidade=").append(quantidadeProd);
            sb.append(", code=").append(codProduct);
            sb.append(", cotacoes=").append(quotations);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash += (idProduto != null ? idProduto.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof Product)) {
                return false;
            }
            Product other = (Product) object;
            if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
                return false;
            }
            return true;
        }

    }
