package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PRODUCTO1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto1.findAll", query = "SELECT p FROM Producto1 p")
    , @NamedQuery(name = "Producto1.findById", query = "SELECT p FROM Producto1 p WHERE p.id = :id")
    , @NamedQuery(name = "Producto1.findByMarca", query = "SELECT p FROM Producto1 p WHERE p.marca = :marca")
    , @NamedQuery(name = "Producto1.findByModelo", query = "SELECT p FROM Producto1 p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Producto1.findByColor", query = "SELECT p FROM Producto1 p WHERE p.color = :color")
    , @NamedQuery(name = "Producto1.findByPrecio", query = "SELECT p FROM Producto1 p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto1.findByCuota", query = "SELECT p FROM Producto1 p WHERE p.cuota = :cuota")})
public class Producto1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "CUOTA")
    private Double cuota;

    public Producto1() {
    }

    public Producto1(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto1)) {
            return false;
        }
        Producto1 other = (Producto1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Producto1[ id=" + id + " ]";
    }

}
