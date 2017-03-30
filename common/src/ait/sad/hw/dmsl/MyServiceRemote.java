package ait.sad.hw.dmsl;

public interface MyServiceRemote {
    public void calculateRevenueRecognitions(long contractNumber);
    public Money recognizedRevenue(long contractNumber, MfDate asOf);
    public long insertProductWP(String name);
    public long insertProductDatabase(String name);
    public long insertProductSpreadsheet(String name);
    public Contract insertContract(long productID, Money revenue, MfDate whenSigned);
    //public int countRecognitions();
    public int fetchRevenueRecognitionSize();
}
