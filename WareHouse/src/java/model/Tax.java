package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Tax {
    private int taxID;
    private String taxName;
    private BigDecimal taxRate;
    private Date effectiveFrom;
    private Date expiredDate;

    public Tax(int taxID, String taxName, BigDecimal taxRate, Date effectiveFrom, Date expiredDate) {
        this.taxID = taxID;
        this.taxName = taxName;
        this.taxRate = taxRate;
        this.effectiveFrom = effectiveFrom;
        this.expiredDate = expiredDate;
    }

    public Tax() {
    }

    public int getTaxID() {
        return taxID;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Date getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}