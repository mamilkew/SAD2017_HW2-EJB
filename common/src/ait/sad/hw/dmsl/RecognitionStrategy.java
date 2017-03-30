package ait.sad.hw.dmsl;

import java.io.Serializable;

public abstract class RecognitionStrategy implements Serializable {
    abstract void calculateRevenueRecognitions(Contract contract);
}
