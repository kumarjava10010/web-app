package com.bank.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.persistance.model.TransactionHistory;

public class TransactionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ArrayList transactionList = new ArrayList();

		for (int i = 0; i < 10; i++) {
			TransactionHistory tranHistory = new TransactionHistory();

			tranHistory.setTransactionId(123 + i);
			tranHistory.setAcctNo(1234);
			tranHistory.setNewBalance("100");
			transactionList.add(tranHistory);
		}

		request.setAttribute("tranHistoryList", transactionList);

		RequestDispatcher rd = request.getRequestDispatcher("transactionHistory.jsp");
		rd.forward(request, response);

	}
}
