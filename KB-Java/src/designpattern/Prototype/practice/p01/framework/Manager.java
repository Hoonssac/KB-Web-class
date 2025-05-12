package designpattern.Prototype.practice.p01.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcard = new HashMap<>();

    public void register(String name, Product prototype) {
        showcard.put(name, prototype);
    }

    public Product create(String name) {
        Product p = showcard.get(name);
        return p.createCopy();
    }
}
