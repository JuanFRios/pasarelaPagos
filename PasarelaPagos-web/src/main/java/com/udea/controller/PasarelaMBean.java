/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.modelo.Transaccion;
import com.udea.session.TransaccionManagerLocal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author juan
 */
public class PasarelaMBean {

    @EJB
    private com.udea.session.TransaccionManagerLocal transaccionManager;

    private Transaccion transaction = new Transaccion();
    private List<Transaccion> transactions;

    public PasarelaMBean() {
    }

    //Retorna una lista de transacciones 
    public List<Transaccion> getTransactions() {
        if (transactions == null || transactions.isEmpty()) {
            refresh();
        }
        return transactions;
    }

    public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        int tipo = Integer.parseInt(((String)arg2).substring(0, 5));
        if (tipo >= 11111 && tipo <= 22222 ) {
            this.transaction.setTipoTCredito("American Express");
            throw new ValidatorException(new FacesMessage("Al menos 5 caracteres "));
            
        }
    }

    public String persist() {
        transaction.setFRegistro(new SimpleDateFormat("yyyy-MM-dd 'a las' HH:mm:ss").format(new Date()));
        System.out.println(transaction.getNombreCliente());
        System.out.println("############################");
        System.out.println("");
        transaccionManager.guardarTransaccion(transaction);
        return "saved";
    }

    public String list() {
        refresh();
        transaction = new Transaccion();
        return "list";
    }

    public String formulario() {
        transaction = new Transaccion();
        return "form";
    }

    private void refresh() {
        this.transactions = this.transaccionManager.getTransacciones();
    }

    public Transaccion getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaccion transaction) {
        this.transaction = transaction;
    }

    public TransaccionManagerLocal getTransactionManager() {
        return transaccionManager;
    }

    public void setTransactionManager(TransaccionManagerLocal transactionManager) {
        this.transaccionManager = transactionManager;
    }

    public String showDetails(Transaccion transaction) {
        this.transaction = transaction;
        return "details";
    }

}
