import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.persistance.model.AcctInfo;
import com.bank.service.BankServiceIfc;


public class MyTest {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		
		BankServiceIfc bankService = (BankServiceIfc)appContext.getBean("bankService");
		
		AcctInfo accountInfo = new AcctInfo();
		accountInfo.setAcctNumber(1210);
		accountInfo.setAcctType("C");
		accountInfo.setBalance("1000.00");
		accountInfo.setLastupdatedby("Robert");
		accountInfo.setLastupdateddate("08/13/2018");
		
		bankService.deposit(accountInfo);
		
		AcctInfo accountInfo1 = bankService.getAcctSummary(1210);
		
		System.out.println(accountInfo1.getAcctType());
		
		//Test
		
		
		/*CustomerDaoIfc customerDao = (CustomerDaoIfc) appContext.getBean("customerDao");
		
		Customer customerObj = new Customer();
		
		customerObj.setAcctNo(1234);
		customerObj.setFirstName("Sunny");
		customerObj.setLastName("Katta");
		customerObj.setSsn("100-00-0000");
		customerObj.setAddress("100 Intersate");
		customerObj.setCity("Friso");
		customerObj.setState("TX");
		customerObj.setZipCode("75035");
		
		//customerDao.delete(customerObj);
		
		customerDao.save(customerObj);
		
		Customer customerObjFromDB = customerDao.findByAcctNumber(1234);
		
		System.out.println(customerObjFromDB.toString());*/
		
	}

}
