/**
 * 
 */
package com.bank.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cragh
 *
 */
@Entity
@Table(name = "acct_transaction_history")
public class TransactionHistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false)
	public Integer transactionId;
	
	@Column(name = "ACCT_NO")
	public Integer acctNo;
	
	@Column(name = "PREV_BALANCE")
	public String prevBalance;
	
	@Column(name = "NEW_BALANCE")
	public String newBalance;
	
	@Column(name = "TRANSACTION_AMOUNT")
	public String transactionAmount;
	
	@Column(name = "TRANSACTION_TYPE")
	public String transactionType;
	
	@Column(name = "TRANSACTION_DATE")
	public String transactionDate;
	
	@Column(name = "BRANCH_NAME")
	public String branchName;
	
	@Column(name = "DEPOSIT_TYPE")
	public String depositType;
	
	@Column(name = "LASTUPDATEDBY")
	public String lastupdatedby;
	
	@Column(name = "LASTUPDATEDDATE")
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
