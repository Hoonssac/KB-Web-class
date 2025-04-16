package ch06.practice.p01;

public class Database {
    static String connection = "MySQL";

    // private 접근 권한을 갖는 정적 필드 선언과 초기화
    private static Database database = new Database();

    // private 접근 권한을 갖는 생성자 선언
    private Database() {
    }

    // 인스턴스 제공 베서드
    public static Database getInstance() {
        return database;
    }

    public static void connect() {
        System.out.println(connection + "에 연결합니다.");
    }

    public static void close() {
        System.out.println(connection + "을 닫습니다.");
    }
}
