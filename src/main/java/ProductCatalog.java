import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xupeng on 2017/6/30.
 */
public class ProductCatalog {
    private Map<String, Beverage> beverages = new HashMap<String, Beverage>();
    private Map<String, Condiment> condiments = new HashMap<String, Condiment>();

    public ProductCatalog() {
        Beverage coffee = new Beverage("Coffee", new BigDecimal(22.00));
        Beverage plainTea = new Beverage("PlainTea", new BigDecimal(25.00));
        Beverage greenTea = new Beverage("GreenTea", new BigDecimal(25.00));
        Beverage blackTea = new Beverage("BlackTea", new BigDecimal(25.00));
        Beverage bear = new Beverage("Bear", new BigDecimal(18.00));
        Beverage coke = new Beverage("Coke", new BigDecimal(12.00));
        beverages.put("Coffee", coffee);
        beverages.put("PlainTea", plainTea);
        beverages.put("GreenTea", greenTea);
        beverages.put("BlackTea", blackTea);
        beverages.put("Bear", bear);
        beverages.put("Coke", coke);

        Condiment sugar = new Condiment("Sugar", BigDecimal.ZERO);
        Condiment milk = new Condiment("Milk", new BigDecimal(3.50));
        Condiment honey = new Condiment("Honey", new BigDecimal(4.50));
        Condiment lemon = new Condiment("Lemon", new BigDecimal(5.00));
        Condiment chocolate = new Condiment("Chocolate", new BigDecimal(7.00));
        Condiment mocha = new Condiment("Mocha", new BigDecimal(8.00));
        condiments.put("Sugar", sugar);
        condiments.put("Milk", milk);
        condiments.put("Honey", honey);
        condiments.put("Lemon", lemon);
        condiments.put("Chocolate", chocolate);
        condiments.put("Mocha", mocha);
    }

    public Beverage findBeverage(String name) {
        return beverages.get(name);
    }

    public Condiment findCondiment(String name) {
        return condiments.get(name);
    }
}
