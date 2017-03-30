package ait.sad.hw.dmsl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.InitialContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ClientTest {
    private static Context ctx;
    private static MyServiceRemote myServiceRemote;
    long newContractID;
	int countBeforeInsert;
	MfDate dateToday;

    @BeforeAll
    static void setup() throws javax.naming.NamingException
    {
        ctx = new InitialContext();
        myServiceRemote = (MyServiceRemote)
                ctx.lookup("java:global/Homework2EJB_ear/ThisBetterWork/TestSessionEJB");

    }
    @Test
    void testcalculateRevenueRecognitions()
    {
        dateToday =  new MfDate();
		    newContractID = myServiceRemote.insertContract(myServiceRemote.insertProductDatabase("MongoDb"), Money.dollars(1000),dateToday).getId();
		    int countBeforeInsert = myServiceRemote.fetchRevenueRecognitionSize();
        myServiceRemote.calculateRevenueRecognitions(newContractID);
        int countAfterInsert = myServiceRemote.fetchRevenueRecognitionSize();
        assertTrue(countAfterInsert>countBeforeInsert);
    }

	@Test
	public void testRecognizedRevenue()
	{
        dateToday =  new MfDate();
		    Money exceptedAmount = Money.dollars(1000.00);
        newContractID = myServiceRemote.insertContract(myServiceRemote.insertProductDatabase("MongoDb"), Money.dollars(1000),dateToday).getId();
        myServiceRemote.calculateRevenueRecognitions(newContractID);
        Money result60 = myServiceRemote.recognizedRevenue(newContractID,dateToday.addDays(60));
		System.out.println(result60.amount());
		assertEquals(exceptedAmount.amount().doubleValue(),result60.amount().doubleValue());

	}
}
