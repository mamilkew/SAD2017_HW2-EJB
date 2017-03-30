//package ait.sad.hw.dmsl;
//
//
//import ait.sad.hw.dmsl.Contract;
//import ait.sad.hw.dmsl.MfDate;
//import ait.sad.hw.dmsl.Money;
//import ait.sad.hw.dmsl.Product;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//public class RecognitionService extends ApplicationService {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void calculateRevenueRecognitions(long contractNumber) {
//        //System.out.println("contractID:" + contractNumber);
//        Contract contract = Contract.findContract(contractNumber);
//        contract.calculateRecognitions();
//
//        //  getEmailGateway().sendEmailMessage(contract.getAdministratorEmailAddress(),"RE: Contract #" + contractNumber, contract + " has had revenue recognitions calculated.");
//        getIntegrationGateway().publishRevenueRecognitionCalculation(contract);
//    }
//
//    public Money recognizedRevenue(long contractNumber, MfDate asOf) {
//        return Contract.findContract(contractNumber).recognizedRevenue(asOf);
//    }
//
//    public void insertProductWP(String name) {
//          addProduct(Product.newWordProcessor(name));
//    }
//
//    public void insertProductDatabase(String name) {
//         addProduct(Product.newDatabase(name));
//    }
//
//    public void insertProductSpreadsheet(String name) {
//         addProduct(Product.newSpreadsheet(name));
//    }
//
//    public Contract insertContract(long productID, Money revenue, MfDate whenSigned) {
//        return addNewContract(Product.findContract(productID), revenue, whenSigned);
//    }
//
////    public int countRecognitions()
////    {	return Contract.countRecognitions();
////    }
////
//    public void addProduct(Product newProduct)
//    {
//
//        entityManager.persist(newProduct);
//        entityManager.flush();
//
//    }
//    public Contract addNewContract(Product product, Money revenue, MfDate whenSigned)
//    {
//        Contract newContract = new Contract(product, revenue, whenSigned);
//        entityManager.persist(newContract);
//        entityManager.flush();
//        return newContract;
//    }
//}