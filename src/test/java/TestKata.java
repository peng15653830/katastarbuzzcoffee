import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xupeng on 2017/6/29.
 */
public class TestKata {
    private ProductCatalog productCatalog;
    private Beverage coffee;
    private Beverage plainTea;
    private Beverage coke;
    private Condiment sugar;
    private Condiment milk;
    private Condiment honey;
    private Condiment lemon;
    private Condiment chocolate;
    private Condiment mocha;

    @Before
    public void setUp(){
        productCatalog = new ProductCatalog();
        coffee = productCatalog.findBeverage("Coffee");
        plainTea = productCatalog.findBeverage("PlainTea");
        coke = productCatalog.findBeverage("Coke");
        sugar = productCatalog.findCondiment("Sugar");
        milk= productCatalog.findCondiment("Milk");
        honey= productCatalog.findCondiment("Honey");
        lemon = productCatalog.findCondiment("Lemon");
        chocolate = productCatalog.findCondiment("Chocolate");
        mocha = productCatalog.findCondiment("Mocha");
    }

    @Test
    public void TestBuyBeverage() {
        OrderLineItem orderLineItem = new OrderLineItem(coffee, 1);
        Order order = new Order();
        order.addLineItem(orderLineItem);
        assertEquals(new BigDecimal(22.00).setScale(2,BigDecimal.ROUND_HALF_DOWN), order.getTotalAmount());
        OrderLineItem orderLineItem2 = new OrderLineItem(plainTea, 1);
        order.addLineItem(orderLineItem2);
        assertEquals(new BigDecimal(47.00).setScale(2,BigDecimal.ROUND_HALF_DOWN), order.getTotalAmount());
        System.out.println(order.getDetail());
    }

    @Test
    public void TestBuyBeverageAndCondiment() {
        OrderLineItem orderLineItem = new OrderLineItem(coffee, 1);
        OrderLineItem orderLineItem2 = new OrderLineItem(milk, 1);
        OrderLineItem orderLineItem3 = new OrderLineItem(honey, 1);
        Order order = new Order();
        order.addLineItem(orderLineItem);
        order.addLineItem(orderLineItem2);
        order.addLineItem(orderLineItem3);
        assertEquals(new BigDecimal(30.00).setScale(2,BigDecimal.ROUND_HALF_DOWN), order.getTotalAmount());
        assertTrue(order.getDetail().contains("Coffee"));
        System.out.println(order.getDetail());
    }

    @Test
    public void TestBuyCokeAndAllCondiment() {
        OrderLineItem cokeItem= new OrderLineItem(coke, 1);
        OrderLineItem sugarItem= new OrderLineItem(sugar, 1);
        OrderLineItem milkItem= new OrderLineItem(milk, 1);
        OrderLineItem honeyItem= new OrderLineItem(honey, 1);
        OrderLineItem lemonItem= new OrderLineItem(lemon, 1);
        OrderLineItem chocolateItem= new OrderLineItem(chocolate, 1);
        OrderLineItem mochaItem= new OrderLineItem(mocha, 1);
        Order order = new Order();
        order.addLineItem(cokeItem);
        order.addLineItem(sugarItem);
        order.addLineItem(milkItem);
        order.addLineItem(honeyItem);
        order.addLineItem(lemonItem);
        order.addLineItem(chocolateItem);
        order.addLineItem(mochaItem);
        assertEquals(new BigDecimal(40.00).setScale(2,BigDecimal.ROUND_HALF_DOWN), order.getTotalAmount());
        assertTrue(order.getDetail().contains("Coke"));
        System.out.println(order.getDetail());
    }
    @Test
    public void TestProductCatalog() {
        assertEquals(new BigDecimal(22.00).setScale(2,BigDecimal.ROUND_HALF_DOWN), coffee.getPrice().setScale(2,BigDecimal.ROUND_HALF_DOWN));
    }
}
