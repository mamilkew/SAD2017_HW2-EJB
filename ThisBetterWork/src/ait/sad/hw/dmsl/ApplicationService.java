package ait.sad.hw.dmsl;

public class ApplicationService {
    protected IntegrationGateway getIntegrationGateway() {
        return new ImplementIntegrationGateway();
    }
}