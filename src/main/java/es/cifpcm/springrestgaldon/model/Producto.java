package es.cifpcm.springrestgaldon.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productoffer")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 512)
    private String nombreProducto;

    @Column(name = "product_price")
    private Float precioProducto;

    @Column(name = "product_picture", length = 512)
    private String imagenProducto;

    @Column(name = "id_municipio", nullable = false)
    private Integer idMunicipio;

    @Column(name = "product_stock", nullable = false)
    private Integer stockProducto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return nombreProducto;
    }

    public void setProductName(String productName) {
        this.nombreProducto = productName;
    }

    public Float getProductPrice() {
        return precioProducto;
    }

    public void setProductPrice(Float productPrice) {
        this.precioProducto = productPrice;
    }

    public String getProductPicture() {
        return imagenProducto;
    }

    public void setProductPicture(String productPicture) {
        this.imagenProducto = productPicture;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(Integer stockProducto) {
        this.stockProducto = stockProducto;
    }

}