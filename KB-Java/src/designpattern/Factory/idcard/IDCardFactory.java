package designpattern.Factory.idcard;

import designpattern.Factory.framework.Factory;
import designpattern.Factory.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProdeuct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
