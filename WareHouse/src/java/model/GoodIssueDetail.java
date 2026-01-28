package model;

public class GoodIssueDetail {
    private int issueDetailID;
    private int issueID;
    private int productDetailID;
    private int quantityExpected;
    private int quantityActual;

    public GoodIssueDetail() {
    }

    public GoodIssueDetail(int issueDetailID, int issueID, int productDetailID, int quantityExpected, int quantityActual) {
        this.issueDetailID = issueDetailID;
        this.issueID = issueID;
        this.productDetailID = productDetailID;
        this.quantityExpected = quantityExpected;
        this.quantityActual = quantityActual;
    }

    public int getIssueDetailID() {
        return issueDetailID;
    }

    public void setIssueDetailID(int issueDetailID) {
        this.issueDetailID = issueDetailID;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public int getQuantityExpected() {
        return quantityExpected;
    }

    public void setQuantityExpected(int quantityExpected) {
        this.quantityExpected = quantityExpected;
    }

    public int getQuantityActual() {
        return quantityActual;
    }

    public void setQuantityActual(int quantityActual) {
        this.quantityActual = quantityActual;
    }
}
