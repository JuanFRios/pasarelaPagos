/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "Transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "Transaccion.findByIdCliente", query = "SELECT t FROM Transaccion t WHERE t.idCliente = :idCliente")
    , @NamedQuery(name = "Transaccion.findByNombreCliente", query = "SELECT t FROM Transaccion t WHERE t.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Transaccion.findByEmail", query = "SELECT t FROM Transaccion t WHERE t.email = :email")
    , @NamedQuery(name = "Transaccion.findByNumTCredito", query = "SELECT t FROM Transaccion t WHERE t.numTCredito = :numTCredito")
    , @NamedQuery(name = "Transaccion.findByCvvTCredito", query = "SELECT t FROM Transaccion t WHERE t.cvvTCredito = :cvvTCredito")
    , @NamedQuery(name = "Transaccion.findByTipoTCredito", query = "SELECT t FROM Transaccion t WHERE t.tipoTCredito = :tipoTCredito")
    , @NamedQuery(name = "Transaccion.findByFVenceTCredito", query = "SELECT t FROM Transaccion t WHERE t.fVenceTCredito = :fVenceTCredito")
    , @NamedQuery(name = "Transaccion.findByValorTotal", query = "SELECT t FROM Transaccion t WHERE t.valorTotal = :valorTotal")
    , @NamedQuery(name = "Transaccion.findByFRegistro", query = "SELECT t FROM Transaccion t WHERE t.fRegistro = :fRegistro")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private Integer idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idCliente")
    private String idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numTCredito")
    private String numTCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cvvTCredito")
    private String cvvTCredito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoTCredito")
    private String tipoTCredito;
    @Column(name = "fVenceTCredito")
    @Temporal(TemporalType.DATE)
    private Date fVenceTCredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;
    @Size(max = 25)
    @Column(name = "fRegistro")
    private String fRegistro;

    public Transaccion() {
    }

    public Transaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transaccion(Integer idTransaccion, String idCliente, String nombreCliente, String email, String numTCredito, String cvvTCredito, String tipoTCredito, BigDecimal valorTotal) {
        this.idTransaccion = idTransaccion;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.numTCredito = numTCredito;
        this.cvvTCredito = cvvTCredito;
        this.tipoTCredito = tipoTCredito;
        this.valorTotal = valorTotal;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTCredito() {
        return numTCredito;
    }

    public void setNumTCredito(String numTCredito) {
        this.numTCredito = numTCredito;
    }

    public String getCvvTCredito() {
        return cvvTCredito;
    }

    public void setCvvTCredito(String cvvTCredito) {
        this.cvvTCredito = cvvTCredito;
    }

    public String getTipoTCredito() {
        return tipoTCredito;
    }

    public void setTipoTCredito(String tipoTCredito) {
        this.tipoTCredito = tipoTCredito;
    }

    public Date getFVenceTCredito() {
        return fVenceTCredito;
    }

    public void setFVenceTCredito(Date fVenceTCredito) {
        this.fVenceTCredito = fVenceTCredito;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFRegistro() {
        return fRegistro;
    }

    public void setFRegistro(String fRegistro) {
        this.fRegistro = fRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Transaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
