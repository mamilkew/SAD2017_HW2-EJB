package ait.sad.hw.dmsl;

import ait.sad.hw.dmsl.Contract;

public class ImplementIntegrationGateway implements IntegrationGateway {

    @Override
    public void publishRevenueRecognitionCalculation(Contract contract) {
        System.out.println("Publishing Revenue Recognition");
    }

}
