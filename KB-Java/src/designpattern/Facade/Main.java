package designpattern.Facade;

import designpattern.Facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
    }
}
