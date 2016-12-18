package com.ro.learn.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rohan on 2016-11-01.
 */
@Entity
@Cacheable(value = true)
@Table(name = "CURRENCY")
@NamedQueries({
        @NamedQuery(
                name = "Currency.findAll", query = "SELECT o FROM Currency o ORDER BY o.currencyCode ASC",
                hints = {
                        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
                        @QueryHint(name = "org.hibernate.readOnly", value = "true")
                }
        ),
        @NamedQuery(
                name = "Currency.findApproved", query = "SELECT o FROM Currency o WHERE o.status = 2 ORDER BY o.currencyCode ASC",
                hints = {
                        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
                        @QueryHint(name = "org.hibernate.readOnly", value = "true")
                }
        )
})
public class Currency {
    @Id
    @Column(name = "CURRENCY_CODE", insertable = true, updatable = true, nullable = false, length = 3)
    private String currencyCode;
    @Column(name = "CURRENCY_NAME", insertable = true, updatable = true, nullable = false, length = 32)
    private String currencyName;
    @Column(name = "SYMBOL", insertable = true, updatable = true, nullable = false, length = 3)
    private String symbol;
    @Column(name = "CURRENCY_PRECISION", insertable = true, updatable = true, nullable = false)
    private int precision;
    @Column(name = "STATUS", insertable = true, updatable = true, nullable = false)
    private int status;
    @Column(name = "CREATED_DATE", insertable = true, updatable = true, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "LAST_UPDATED", insertable = true, updatable = true, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
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

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
