package com.example.restservicenumberconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NumberConverterController {
    private static String answerMessage = "";
    private static String answerVal = "";
    private final AtomicLong counter = new AtomicLong();
    Integer intToConvert;

    @GetMapping("/NumberConversion")
    public NumberConverter numberConverter(@RequestParam(value="mode", defaultValue = "toHex") String mode,
                                           @RequestParam(value="numToConvert", defaultValue = "16") String numToConvert) {
        try {
            intToConvert = Integer.valueOf(numToConvert);
        }catch (NumberFormatException exception){
            answerMessage = "Wrong input number pass positive int";
            return new NumberConverter(counter.incrementAndGet(), mode, numToConvert, answerMessage);
        }

        if(intToConvert <= 0){
            answerMessage = "Wrong input number pass positive int";
            return new NumberConverter(counter.incrementAndGet(), mode, numToConvert, answerMessage);
        }

        if (mode.equals("toHex")) {
            answerVal = Integer.toHexString(intToConvert);
        } else if (mode.equals("toRoman")) {
            answerVal = integerToRoman(intToConvert);
        } else {
            answerMessage = "Wrong input mode";
            return new NumberConverter(counter.incrementAndGet(), mode, numToConvert, answerMessage);
        }
        answerMessage = "For: " + numToConvert + " and conversion mode: " + mode + " Result is: " + answerVal;
        return new NumberConverter(counter.incrementAndGet(), mode, numToConvert, answerMessage);
    }

    private String integerToRoman(int num) {

        System.out.println("Integer: " + num);
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}
