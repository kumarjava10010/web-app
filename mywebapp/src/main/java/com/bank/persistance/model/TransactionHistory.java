/**
 * 
 */
package com.bank.persistance.model;

/**
 * @author cragh
 *
 */
public class TransactionHistory {

	public Integer transactionId;
	public Integer acctNo;
	public String prevBalance;
	public String newBalance;
	public String transactionAmount;
	public String transactionType;
	public String transactionDate;
	public String branchName;
	public String depositType;
	public String lastupdatedby;
	public String lastupdateddate;

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the acctNo
	 */
	public Integer getAcctNo() {
		return acctNo;
	}

	/**
	 * @param acctNo
	 *            the acctNo to set
	 */
	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}

	/**
	 * @return the prevBalance
	 */
	public String getPrevBalance() {
		return prevBalance;
	}

	/**
	 * @param prevBalance
	 *            the prevBalance to set
	 */
	public void setPrevBalance(String prevBalance) {
		this.prevBalance = prevBalance;
	}

	/**
	 * @return the newBalance
	 */
	public String getNewBalance() {
		return newBalance;
	}

	/**
	 * @param newBalance
	 *            the newBalance to set
	 */
	public void setNewBalance(String newBalance) {
		this.newBalance = newBalance;
	}

	/**
	 * @return the transactionAmount
	 */
	public String getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount
	 *            the transactionAmount to set
	 */
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionDate
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate
	 *            the transactionDate to set
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName
	 *            the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the depositType
	 */
	public String getDepositType() {
		return depositType;
	}

	/**
	 * @param depositType
	 *            the depositType to set
	 */
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	/**
	 * @return the lastupdatedby
	 */
	public String getLastupdatedby() {
		return lastupdatedby;
	}

	/**
	 * @param lastupdatedby
	 *            the lastupdatedby to set
	 */
	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	/**
	 * @return the lastupdateddate
	 */
	public String getLastupdateddate() {
		return lastupdateddate;
	}

	/**
	 * @param lastupdateddate
	 *            the lastupdateddate to set
	 */
	public void setLastupdateddate(String lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

}
