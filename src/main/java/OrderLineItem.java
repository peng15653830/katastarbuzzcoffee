import java.math.BigDecimal;

/**
 * Created by xupeng on 2017/6/29.
 */
public class OrderLineItem {
    private Product product;
    private Integer quantity;

    public OrderLineItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getSubAmount() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }

    @Override
    public String toString() {
        return product.toString();
    }
}
