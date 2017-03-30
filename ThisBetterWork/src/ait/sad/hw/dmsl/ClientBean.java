package ait.sad.hw.dmsl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Remote
@Stateless(name = "TestSessionEJB")
public class ClientBean implements MyServiceRemote{

    @PersistenceContext
    private  EntityManager entityManager;
    public ClientBean() {
    }

    public void calculateRevenueRecognitions(long contractNumber) {

        Contract contract = findContract(contractNumber);
        contract.calculateRecognitions();

    }

    public Money recognizedRevenue(long contractNumber, MfDate asOf) {
        return findContract(contractNumber).recognizedRevenue(asOf);
    }

    public long insertProductWP(String name)
    {
        Product product = Product.newWordProcessor(name);
        addProduct(product);
        return product.getId();
    }

    public long insertProductDatabase(String name)
    {
        Product product = Product.newDatabase(name);
        addProduct(product);
        return product.getId();
    }

    public long insertProductSpreadsheet(String name)
    {
        Product product = Product.newSpreadsheet(name);
        addProduct(product);
        return product.getId();

    }

    public Contract insertContract(long productID, Money revenue, MfDate whenSigned)
    {
        return  addNewContract(findProduct(productID), revenue, whenSigned);
    }

//    public int countRecognitions()
//    {
//        return Contract.countRecognitions();
//    }

    public void addProduct(Product product)
    {
        entityManager.persist(product);
        entityManager.flush();
    }

    public Contract addNewContract(Product product, Money revenue, MfDate whenSigned)
    {
        Contract newContract = new Contract(product, revenue, whenSigned);
        entityManager.persist(newContract);
        entityManager.flush();
        return newContract;
    }

    public Contract findContract(long contractID) {
        return entityManager.find(Contract.class, contractID);
    }
    public Product findProduct(long productID) {
        return entityManager.find(Product.class, productID);
    }

    public int fetchRevenueRecognitionSize() {
        Query query = entityManager.createQuery("SELECT r FROM RevenueRecognition  as r");
        List<Contract> results = query.getResultList();
        return results.size();
    }
}
