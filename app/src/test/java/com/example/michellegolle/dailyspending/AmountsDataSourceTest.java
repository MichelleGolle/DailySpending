package com.example.michellegolle.dailyspending;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import java.util.List;


import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)


public class AmountsDataSourceTest {
    private AmountsDataSource datasource;

    @Before
    public void setUp(){
        datasource = new AmountsDataSource(RuntimeEnvironment.application);
        datasource.open();
    }

    @After
    public void finish() {
        datasource.close();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(datasource);
    }

    @Test
    public void createAmount() throws Exception {
        Amount amount = new Amount();
        amount.setAmount("5.55");
        datasource.createAmount(amount);
        List<Amount> amounts = datasource.getAllAmounts();
        int amountCount = amounts.size();
        assertEquals(amountCount, 1);
    }
//
//    @Test
//    public void deleteAmount() throws Exception {
//        Amount amount1 = new Amount();
//        amount1.setAmount("3.33");
//        datasource.createAmount(amount1);
//        System.out.println(amount1.getId());
//        System.out.println(amount1.getAmount());
//        Amount amount2 = new Amount();
//        amount2.setAmount("4.44");
//        datasource.createAmount(amount2);
//        System.out.println(amount2.getId());
//        System.out.println(amount2.getAmount());
//        datasource.deleteAmount(amount1);
//        List<Amount> amounts = datasource.getAllAmounts();
//        int amountCount = amounts.size();
//        assertEquals(amountCount, 1);
//    }


}
