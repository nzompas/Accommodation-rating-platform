package api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class accommodationTest {
accommodation acc=new accommodation(0);

    accommodationTest() throws IOException {
    }

    @org.junit.jupiter.api.Test
    void files() throws IOException {
    }

    @org.junit.jupiter.api.Test
    void addAccommodations() {
    }

    @org.junit.jupiter.api.Test
    void toFiles() {
    }


   @org.junit.jupiter.api.Test
    public void findPrAccom()  {
        assertEquals(0,acc.findPrAccom("erifililouk","Palace"));
    }


    @org.junit.jupiter.api.Test
    void deleteAccom() {
    }

    @org.junit.jupiter.api.Test
    void deleteAccommodations() {
    }

    @org.junit.jupiter.api.Test
    void changeAccommodations() {
    }

    @org.junit.jupiter.api.Test
    void findAccom() {
        assertEquals(true,acc.findAccom("Palace"));
    }

    @org.junit.jupiter.api.Test
    void paccomm() {

    }

    @org.junit.jupiter.api.Test
    void findAcc() {
        assertEquals(0,acc.findAcc("Palace"));
    }
}