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

     
    public String continuar(){
        String r = "invalido";
        String tipo = this.transaction.getNumTCredito().substring(0,5);
        int tip = Integer.parseInt(tipo);
        if(tip >=11111 && tip <=22222){
            this.transaction.setTipoTCredito("American Express");
            r = "valido";
        }else if(tip >=33334 && tip <=44444){
            this.transaction.setTipoTCredito("Diners");
            r = "valido";
        }else if(tip >=55555 && tip <=66666){
            this.transaction.setTipoTCredito("Visa");
            r = "valido";
        }else if(tip >=77777 && tip <=88888){
            this.transaction.setTipoTCredito("Master Card");
            r = "valido";
        }
        return r;
    }
    

    public String persist() {
        transaction.setFRegistro(new SimpleDateFormat("yyyy-MM-dd 'a las' HH:mm:ss").format(new Date()));        
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
