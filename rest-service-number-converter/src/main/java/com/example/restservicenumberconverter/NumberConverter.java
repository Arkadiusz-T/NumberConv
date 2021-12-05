package com.example.restservicenumberconverter;

public class NumberConverter {

    private final long id;
    private final String mode;
    private final String numToConvert;
    private final String answer;

    public NumberConverter(long id, String mode, String numToConvert, String answer){
        this.id = id;
        this.mode = mode;
        this.numToConvert = numToConvert;
        this.answer = answer;
    }
    public long getId() {
        return id;
    }

    public String getMode() {
        return mode;
    }

    public String getNumToConvert() {
        return numToConvert;
    }
    public String getAnswer() {
        return answer;
    }
}
