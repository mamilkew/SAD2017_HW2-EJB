package ait.sad.hw.dmsl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name="HwContract")
public class Contract implements Serializable{
    private Money revenue;
    private MfDate whenSigned;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToMany(cascade = CascadeType.ALL)
    private List<RevenueRecognition> revenueRecognitions = new ArrayList<RevenueRecognition>();

    @ManyToOne (cascade ={ CascadeType.ALL })
    private Product product;

    public Contract() {
    }
//    @PersistenceContext
//    static private EntityManager entityManager;

    public Contract(Product product, Money revenue, MfDate whenSigned) {
    	//this.id = (long) (allContracts.size()+1);
        this.product = product;
        this.revenue = revenue;
        this.whenSigned = whenSigned;
    }

   //private static List <Contract> allContracts = new ArrayList<Contract>();

    public void setRevenue(Money revenue) {
        this.revenue = revenue;
    }

    public void setWhenSigned(MfDate whenSigned) {
        this.whenSigned = whenSigned;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Money getRevenue() {
        return revenue;
    }

    public MfDate getWhenSigned() {
        return whenSigned;
    }

    public long getId()
    {
    	return id;
    }

    public  int countRecognitions() {
		// TODO Auto-generated method stub
		return revenueRecognitions.size();
        //return 1;
	}


    public void setRevenueRecognitions(List<RevenueRecognition> revenueRecognitions) {
        this.revenueRecognitions = revenueRecognitions;
    }


    public Money recognizedRevenue(MfDate asOf) {
        Money result = Money.dollars(0);
        Iterator<RevenueRecognition> it = revenueRecognitions.iterator();
        while (it.hasNext()) {
            RevenueRecognition r = (RevenueRecognition) it.next();
            if (r.isRecognizableBy(asOf))
                result = result.add(Money.dollars(r.getAmount()));
        }
        return result;
    }

    public void calculateRecognitions() {
        product.calculateRevenueRecognitions(this);
    }

    public void addRevenueRecognition(RevenueRecognition revenueRecognition) {
        revenueRecognitions.add(revenueRecognition);
    }

    public List<RevenueRecognition> getRevenueRecognitions() {
        return revenueRecognitions;
    }
}