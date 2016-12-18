package com.ro.learn.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rohan on 2016-11-01.
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
        @NamedQuery(
                name = "Customer.findAll", query = "SELECT o FROM Customer o"
        ),
        @NamedQuery(
                name = "Customer.findByLoginName", query = "SELECT o FROM Customer o WHERE o.loginName = :loginName"
        )
})
public class Customer {
    @Id
    @Column(name = "MERCHANT_CODE", insertable = true, updatable = false, nullable = false)
    private long merchantCode;
    @Column(name = "LOGIN_NAME", insertable = true, updatable = true, nullable = false, length = 20)
    private String loginName;
    @Column(name = "PASSWORD", insertable = true, updatable = true, nullable = true, length = 40)
    private String password;
    @Column(name = "NO_OF_LOGINS", insertable = true, updatable = true, nullable = false)
    private int noOfLogins;
    @Column(name = "NO_OF_FAILED_LOGINS", insertable = true, updatable = true, nullable = false)
    private int noOfFailedLogins;
    @Column(name = "LAST_LOGIN_DATE", insertable = true, updatable = true, nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Column(name = "NAME", insertable = true, updatable = true, nullable = true, length = 255)
    private String name;
    @Column(name = "DATE_OF_BIRTH", insertable = true, updatable = true, nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "CREATED_DATE", insertable = true, updatable = true, nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "MOBILE", insertable = true, updatable = true, nullable = false, length = 40)
    private String mobile;
    @Column(name = "EMAIL", insertable = true, updatable = true, nullable = false, length = 40)
    private String email;
    @Column(name = "STATUS", insertable = true, updatable = true, nullable = false)
    private int status;
    @Column(name = "ID_STATUS", insertable = true, updatable = true, nullable = false)
    private int idStatus;
    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private Account account;

    public long getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(long merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoOfLogins() {
        return noOfLogins;
    }

    public void setNoOfLogins(int noOfLogins) {
        this.noOfLogins = noOfLogins;
    }

    public int getNoOfFailedLogins() {
        return noOfFailedLogins;
    }

    public void setNoOfFailedLogins(int noOfFailedLogins) {
        this.noOfFailedLogins = noOfFailedLogins;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
