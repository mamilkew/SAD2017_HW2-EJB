//package ait.sad.hw.dmsl;//package ait.sad.hw.dml;
//
//
//import ait.sa.hw.dmsl.MfDate;
//import ait.sa.hw.dmsl.Money;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class JUnitTestDMSL {
//
//	RecognitionService rs = new RecognitionService();
//	long newContractID;
//	int countBeforeInsert;
//	MfDate dateToday;
//
////	@BeforeAll
////	public void initialSetup()
////	{
////		dateToday = new MfDate();
////		newContractID = rs.insertContract(rs.insertProductDatabase("MongoDb"), Money.dollars(1000),dateToday).getId();
////		countBeforeInsert = rs.countRecognitions();
////		rs.calculateRevenueRecognitions(newContractID);
////	}
//
//	@Test
//	public void testcalculateRevenueRecognitions()
//	{
//		rs.insertProductDatabase("MongoDb");
////		System.out.println("newContractID: "+newContractID);
////		int countAfterInsert = rs.countRecognitions();
////		assertTrue(countAfterInsert > countBeforeInsert);
//	}
//
////	@Test
////	public void testRecognizedRevenue()
////	{
////		Money exceptedAmount60 = Money.dollars(1000.00);
////		Money result60 = rs.recognizedRevenue(newContractID,dateToday.addDays(60));	System.out.println(result60.amount());
////		assertEquals(result60, exceptedAmount60);
////	}
//
//}
