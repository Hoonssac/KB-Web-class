package ch06.practice.p01;

public class DatabaseExample {
    public static void main(String[] args) {
        Database db = Database.getInstance();

        db.connect();
        System.out.println("데이터베이스: " + Database.connection);
        db.close();
    }
}
