package designpattern.Factory.framework;

public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProdeuct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProdeuct(Product product);
}
