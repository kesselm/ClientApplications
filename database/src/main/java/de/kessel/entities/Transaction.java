package de.kessel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    @Column(name="auftraggeber")
    private String auftraggeber;

    @Column(name="verwendungszweck")
    private String verwendungszweck;

    @Column(name="saldo")
    private BigDecimal saldo;

    @Column(name="betrag")
    private BigDecimal betrag;

    @Column(name="waehrung")
    private String waehrung;

    public Transaction(Date bookingDate, String auftraggeber,
                       String buchungstext, String verwendungszweck,
                       BigDecimal saldo, BigDecimal betrag, String waehrung) {

        this.bookingDate = bookingDate;
        this.auftraggeber = auftraggeber;
        this.verwendungszweck = verwendungszweck;
        this.saldo = saldo;
        this.betrag = betrag;
        this.waehrung = waehrung;
    }

    public Transaction() {

    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getAuftraggeber() {
        return auftraggeber;
    }

    public void setAuftraggeber(String auftraggeber) {
        this.auftraggeber = auftraggeber;
    }

    public String getVerwendungszweck() {
        return verwendungszweck;
    }

    public void setVerwendungszweck(String verwendungszweck) {
        this.verwendungszweck = verwendungszweck;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    public String getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(String waehrung) {
        this.waehrung = waehrung;
    }

    public String toString() {
        return "";
    }
}
