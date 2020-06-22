package com.ogur.airlines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id ;

    @ManyToOne(cascade = CascadeType.ALL)      // many to one relation between passenger
    @JoinColumn(name = "account_passenger_id")
    @JsonIgnore
    private Passenger passenger;

    @Column(name = "account_card_number",  unique = true)
    private String cardNumber;

    @Column(name = "account_expire_year" , length = 4)
    private int expireYear;

    @Column(name = "account_expire_month", length = 2)
    private int expireMonth;

    public Account( )
    {

    }

    public Integer getId( )
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public int getExpireYear()
    {
        return expireYear;
    }

    public void setExpireYear(int expireYear)
    {
        this.expireYear = expireYear;
    }

    public int getExpireMonth()
    {
        return expireMonth;
    }

    public void setExpireMonth(int expireMonth)
    {
        this.expireMonth = expireMonth;
    }

    @Override
    public String toString()
    {
        return "Account{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expireYear=" + expireYear +
                ", expireMonth=" + expireMonth +
                '}';
    }
}
