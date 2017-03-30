package ait.sad.hw.dmsl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="HwProduct")
public class Product implements Serializable {
	 	private String name;
	    private RecognitionStrategy recognitionStrategy;
	    //private static List<Product> productList= new ArrayList<Product>();

	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		public static List<Contract> getContractList() {
			return contractList;
		}

		public static void setContractList(List<Contract> contractList) {
			Product.contractList = contractList;
		}

	@OneToMany (cascade ={ CascadeType.ALL },fetch=FetchType.EAGER)

		private static List<Contract> contractList = new ArrayList<Contract>();

		public Product(String name, RecognitionStrategy recognitionStrategy) {
	    	this.name = name;
	        this.recognitionStrategy = recognitionStrategy;
	    }

		public Product() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public RecognitionStrategy getRecognitionStrategy() {
			return recognitionStrategy;
		}

		public void setRecognitionStrategy(RecognitionStrategy recognitionStrategy) {
			this.recognitionStrategy = recognitionStrategy;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public static Product newWordProcessor(String name) {
			Product newProduct = new Product(name, new CompleteRecognitionStrategy());
	        return newProduct;
	    }
		
	    public static Product newSpreadsheet(String name) {
	    	Product newProduct = new Product(name, new ThreeWayRecognitionStrategy(60, 90));
	        return newProduct;
	    }
	    public static Product newDatabase(String name) {
	    	Product newProduct =  new Product(name, new ThreeWayRecognitionStrategy(30, 60));
	        return newProduct;
	    }

	    public void calculateRevenueRecognitions(Contract contract) {
	    	recognitionStrategy.calculateRevenueRecognitions(contract);

	    }

	    public long getId()
	    {
	    	return id;
	    }
}
