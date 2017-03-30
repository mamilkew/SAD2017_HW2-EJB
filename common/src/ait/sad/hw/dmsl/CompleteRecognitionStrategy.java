package ait.sad.hw.dmsl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

public class CompleteRecognitionStrategy extends RecognitionStrategy {
    void calculateRevenueRecognitions(Contract contract) {
        contract.addRevenueRecognition(new RevenueRecognition(contract.getRevenue(), contract.getWhenSigned(),contract));
    }

}
