package designpattern.Prototype.practice.p01;


import designpattern.Prototype.practice.p01.framework.Manager;
import designpattern.Prototype.practice.p01.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        CardTemplate instagramPost = new CardTemplate("[Instagram Post]", '~');
        CardTemplate youtubePost = new CardTemplate("[Youtube Thumbnail", '#');
        manager.register("insta", instagramPost);
        manager.register("youtube", youtubePost);
        Product p1 = manager.create("insta");
        Product p2 = manager.create("youtube");
        p1.use("오늘 점심은 연남동 김밥 🍙");
        System.out.println();
        p2.use("🔥 자바로 구현한 내 인생 첫 프로그램!");
    }
}
