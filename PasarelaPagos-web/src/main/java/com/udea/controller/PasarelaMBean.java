/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.modelo.Transaccion;
import com.udea.session.TransaccionManagerLocal;
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
    
    public String persist() {
        System.out.println(transaction.getNombreCliente());
        System.out.println("############################");
        System.out.println("");
        transaccionManager.guardarTransaccion(transaction);
        return "saved";
    }
    
    public String list() {
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
    
    public String showDetails(Transaccion transaction){
        this.transaction = transaction;
        return "details";
    }
  
}
