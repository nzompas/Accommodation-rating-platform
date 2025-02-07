package api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {
Provider p=new Provider();

    ProviderTest() throws IOException {
    }

    @Test
    void files() {
    }

    @Test
    void addData() {
    }

    @Test
    void ifnameisprovider() {
        assertEquals(false,p.ifnameisprovider("dgbgd","9861"));
    }

    @Test
    void addProvider() {
    }

    @Test
    void addfile() {
    }

    @Test
    void ifnameexist() {
        assertEquals(false,p.ifnameexist("bdbdbdbd"));
    }

    @Test
    void findpr() {
        assertEquals(0,p.findpr("erifililouk"));
    }
}