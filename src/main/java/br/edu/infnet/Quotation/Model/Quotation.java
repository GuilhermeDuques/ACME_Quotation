package br.edu.infnet.Quotation.Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "quotations")
@NamedQueries({
        @NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q"),
        @NamedQuery(name = "Quotation.findByQuotationId", query = "SELECT q FROM Quotation q WHERE q.idCotacao = :quotationId"),
        @NamedQuery(name = "Quotation.findByproductPrice", query = "SELECT q FROM Quotation q WHERE q.precoProdu= :productPrice"),
        @NamedQuery(name = "Quotation.findByProduct", query = "SELECT q FROM Quotation q WHERE q.produto = :product")})
public class Quotation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "quotation_id")
    private Short idCotacao;
    @Column(name = "product_price")
    private String precoProdu;
    @Basic(optional = false)
    @Column(name = "product")
    private String produto;
    @Basic(optional = false)
    @Column(unique=true)
    private int codProduct;

    public Quotation() {

    }

    public Quotation(Short idCotacao) {
        this.idCotacao = idCotacao;
    }

    public Quotation(Short idCotacao, String precoProdu, String produto) {
        this.idCotacao = idCotacao;
        this.precoProdu = precoProdu;
        this.produto = produto;
    }

    public Short getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Short quotationId) {
        this.idCotacao = quotationId;
    }

    public String getPrecoProdu() {
        return precoProdu;
    }

    public void setPrecoProdu(String productPrice) {
        this.precoProdu = productPrice;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String product) {
        this.produto = product;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quotation{id=").append(idCotacao);
        sb.append(", price=").append(precoProdu);
        sb.append(", product=").append(produto);
        sb.append(", code=").append(codProduct);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotacao != null ? idCotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotation)) {
            return false;
        }
        Quotation other = (Quotation) object;
        if ((this.idCotacao == null && other.idCotacao != null) || (this.idCotacao != null && !this.idCotacao.equals(other.idCotacao))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
        return "org.edu.infnet.Quotation.model.Quotation[ quotationId=" + quotationId + " ]";
    }*/
}


