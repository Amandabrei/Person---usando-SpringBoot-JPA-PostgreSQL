package br.com.erudio;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrder {
    
    @Test
    @Order(1)
    void testC() {
        System.out.println("Running Test C");
    }
    
    @Test
    @Order(2)
    void testD() {
        System.out.println("Running Test D");
    }
    
    @Test
    @Order(3)
    void testA() {
        System.out.println("Running Test A");
    }
    
    @Test
    @Order(4)
    void testB() {
        System.out.println("Running Test B");
    }

}
