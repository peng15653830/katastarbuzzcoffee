import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupeng on 2017/6/29.
 */
public class Order {
    List<OrderLineItem> orderLineItems = new ArrayList<OrderLineItem>();

    public void addLineItem(OrderLineItem orderLineItem) {
        orderLineItems.add(orderLineItem);
    }

    public BigDecimal getTotalAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (OrderLineItem orderLineItem : orderLineItems) {
            totalAmount = totalAmount.add(orderLineItem.getSubAmount());
        }
        return totalAmount.setScale(2,BigDecimal.ROUND_HALF_DOWN);
    }

    public String getDetail(){
        String result="";
        for(int i=0;i<orderLineItems.size();i++){
            if(i==orderLineItems.size()-1){
                result+=orderLineItems.get(i).toString();
            }else {
                result += orderLineItems.get(i).toString() + "+";
            }
        }
        return result+"|"+getTotalAmount();
    }
}
