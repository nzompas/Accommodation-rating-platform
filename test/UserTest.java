package api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
User u=new User();

    UserTest() throws IOException {
    }

    @Test
    void files() {
    }

    @Test
    void addData() {
    }

    @Test
    void ifnameisuser() {
        assertEquals(false,u.ifnameisuser("user","1111"));
    }

    @Test
    void addUser() {
    }

    @Test
    void addfile() {
    }

    @Test
    void ifnameexist() {
        assertEquals(false,u.ifnameexist("user"));
    }

    @Test
    void findpr() {
        assertEquals(0,u.findpr("user1"));
    }
}