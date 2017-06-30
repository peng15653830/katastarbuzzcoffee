import java.math.BigDecimal;

/**
 * Created by xupeng on 2017/6/29.
 */
public class Beverage implements Product {
    private String description;
    private BigDecimal price;

    public Beverage(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }


    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description + "(" + price + ")";
    }
}
