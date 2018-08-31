package com.bank.persistance.model;

public class AccountJson {

	private Integer acctNumber;

	private String acctType;

	private String balance;

	private String lastupdatedby;

	private String lastupdateddate;

	private String transactionAmount;
	private String transactionType;

	/**
	 * @return the acctNumber
	 */
	public Integer getAcctNumber() {
		return acctNumber;
	}

	/**
	 * @param acctNumber
	 *            the acctNumber to set
	 */
	public void setAcctNumber(Integer acctNumber) {
		this.acctNumber = acctNumber;
	}

	/**
	 * @return the acctType
	 */
	public String getAcctType() {
		return acctType;
	}

	/**
	 * @param acctType
	 *            the acctType to set
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountJson [acctNumber=" + acctNumber + ", acctType=" + acctType + ", balance=" + balance
				+ ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate + ", transactionAmount="
				+ transactionAmount + ", transactionType=" + transactionType + "]";
	}
	
	

}
