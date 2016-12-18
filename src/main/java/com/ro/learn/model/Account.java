package com.ro.learn.model;

import com.ro.learn.util.Constants;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rohan on 2016-12-18.
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
        @NamedQuery(
                name = "Account.findAll", query = "SELECT o FROM Account o"
        )
})
public class Account {
    //todo explain sequence generator, table generator etc
    @Id
    @TableGenerator(name = "ACCOUNT_ID_GEN", table = "SEQ_STORE", pkColumnName = "SEQ_NAME", pkColumnValue = "ACCOUNT.ACCOUNT_ID", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ACCOUNT_ID_GEN")
    @Column(name = "ACCOUNT_ID", insertable = true, updatable = false, nullable = false)
    private long accountId;
    @ManyToOne(fetch = FetchType.EAGER)//todo explain relationship
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY")
    private Currency currency;
    @Column(name = "BALANCE", insertable = true, updatable = true, nullable = false, precision = Constants.PRECISION, scale = Constants.SCALE)
    private BigDecimal balance;//todo explain precision, scale
    @Column(name = "STATUS", insertable = true, updatable = true, nullable = false)
    private int status;
    @Column(name = "CREATED_DATE", insertable = true, updatable = true, nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)//todo explain data, time, datetime types
    private Date createdDate;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
