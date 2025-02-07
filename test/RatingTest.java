package api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
Rating r=new Rating(1);

    RatingTest() throws IOException {
    }

    @Test
    void files() {
    }

    @Test
    void addrat() {
    }

    @Test
    void addratToFiles() {
    }

    @Test
    void findRat() {
        assertEquals(-1,r.findRat("user","Palace"));
    }

    @Test
    void deleterat() {
    }

    @Test
    void processRat() {
    }

    @Test
    void totalr() {
        ArrayList<String> x=new ArrayList<>();
        x.add("fhdett");
        assertEquals(0.0,r.totalr(x,0));
    }

    @Test
    void uaccomm() {
    }

    @Test
    void arat() {
    }

    @Test
    void ratAccom() {
        assertEquals(0,r.ratAccom("Palace","user1"));
    }
}