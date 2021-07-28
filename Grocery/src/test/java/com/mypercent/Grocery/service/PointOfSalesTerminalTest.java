package com.mypercent.Grocery.service;

import com.mypercent.Grocery.Model.Product;
import com.mypercent.Grocery.Model.Volume;
import com.mypercent.Grocery.Service.PointOfSalesTerminal;
import com.mypercent.Grocery.serviceImp.PointOfSalesTerminalImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

//@SpringBootTest
public class PointOfSalesTerminalTest {
//    @Autowired
    private PointOfSalesTerminal pointOfSalesTerminal;

   private Volume volume1;
   private Product product1;
  private   Product product2;
   private Volume volume2;
    private Product product3;
   private Product product4;
    @BeforeEach
    void initSetup(){
        pointOfSalesTerminal= new PointOfSalesTerminalImp();
          volume1 = new Volume(3, BigDecimal.valueOf(3));
          product1 = new Product("A", "A", BigDecimal.valueOf(1.25), volume1);
          product2 = new Product("B", "B", BigDecimal.valueOf(4.25),null);

          volume2 = new Volume(6, BigDecimal.valueOf(5));
          product3 = new Product("C", "C", BigDecimal.valueOf(1), volume2);
          product4 = new Product("D", "D", BigDecimal.valueOf(0.75), null);

    }

    @Test
    void testCheckoutOne(){
//Scan these items in this order:ABCDABA; Verify thetotal price is$13.25
        pointOfSalesTerminal.scan(product1);
        pointOfSalesTerminal.scan(product2);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product4);
        pointOfSalesTerminal.scan(product1);
        pointOfSalesTerminal.scan(product2);
        pointOfSalesTerminal.scan(product1);

        assertThat(BigDecimal.valueOf(13.25),is(equalTo(pointOfSalesTerminal.calculateTotal())));
    }

    @Test
    void testCheckoutTwo(){
//Scan these items in this order: CCCCCCC; Verify the total price is $6.00.
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product3);
        assertThat(BigDecimal.valueOf(6),is(equalTo(pointOfSalesTerminal.calculateTotal())));
    }

    @Test
    void testCheckoutThree(){
//Scan these items in this order: ABCD; Verify the total price is $7.25.
        pointOfSalesTerminal.scan(product1);
        pointOfSalesTerminal.scan(product2);
        pointOfSalesTerminal.scan(product3);
        pointOfSalesTerminal.scan(product4);
        assertThat(BigDecimal.valueOf(7.25),is(equalTo(pointOfSalesTerminal.calculateTotal())));
    }

}
