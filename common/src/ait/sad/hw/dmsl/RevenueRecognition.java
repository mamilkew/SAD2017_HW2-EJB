package ait.sad.hw.dmsl;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="HwRevenue")
public class RevenueRecognition implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double amount;
    private MfDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Contract contract;

    public RevenueRecognition(Money amount, MfDate date, Contract contract) {
        this.amount = amount.amount().doubleValue();
        this.date = date;
        this.contract = contract;
    }

    public RevenueRecognition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public MfDate getDate() {
        return date;
    }

    public void setDate(MfDate date) {
        this.date = date;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Double getAmount() {
        return amount;
    }
    
    public boolean isRecognizableBy(MfDate asOf) {
        return asOf.after(date) || asOf.equals(date);
    }	
}