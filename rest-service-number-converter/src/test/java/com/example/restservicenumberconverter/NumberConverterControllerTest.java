package com.example.restservicenumberconverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterControllerTest {

    @Test
    void numberConverterToRoman() {
        NumberConverterController ncc = new NumberConverterController();
        NumberConverter nc = ncc.numberConverter("toRoman", "16");
        assertEquals("For: 16 and conversion mode: toRoman Result is: XVI", nc.getAnswer());
    }

    @Test
    void numberConverterToHex() {
        NumberConverterController ncc = new NumberConverterController();
        NumberConverter nc = ncc.numberConverter("toHex", "17");
        assertEquals("For: 17 and conversion mode: toHex Result is: 11", nc.getAnswer());
    }

    @Test
    void numberConverterWrgMode() {
        NumberConverterController ncc = new NumberConverterController();
        NumberConverter nc = ncc.numberConverter("toGo", "17");
        assertEquals("Wrong input mode", nc.getAnswer());
    }

    @Test
    void numberConverterWrgNumToConvert() {
        NumberConverterController ncc = new NumberConverterController();
        NumberConverter nc = ncc.numberConverter("toHex", "17a");
        assertEquals("Wrong input number pass positive int", nc.getAnswer());
    }

    @Test
    void numberConverterNgtvNumToConvert() {
        NumberConverterController ncc = new NumberConverterController();
        NumberConverter nc = ncc.numberConverter("toHex", "-17");
        assertEquals("Wrong input number pass positive int", nc.getAnswer());
    }
}