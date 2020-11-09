package com.udea.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-08T21:32:54")
@StaticMetamodel(Transaccion.class)
public class Transaccion_ { 

    public static volatile SingularAttribute<Transaccion, Integer> idTransaccion;
    public static volatile SingularAttribute<Transaccion, String> tipoTCredito;
    public static volatile SingularAttribute<Transaccion, Date> fVenceTCredito;
    public static volatile SingularAttribute<Transaccion, String> fRegistro;
    public static volatile SingularAttribute<Transaccion, String> idCliente;
    public static volatile SingularAttribute<Transaccion, String> nombreCliente;
    public static volatile SingularAttribute<Transaccion, String> cvvTCredito;
    public static volatile SingularAttribute<Transaccion, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Transaccion, String> numTCredito;
    public static volatile SingularAttribute<Transaccion, String> email;

}