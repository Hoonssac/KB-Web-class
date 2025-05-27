package sec01;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {
	public static void main(String[] args) {
		// MongoDB 서버 URI 설정
		String url = "mongodb://127.0.0.1:27017";
		// 사용할 데이터베이스 이름 설정
		String db = "todo_db";

		// MondoDB 클라이언트 생성 및 연결 시도
		try (MongoClient client = MongoClients.create(url)) {
			// 지정된 데이터베이스 가져오기
			MongoDatabase database = client.getDatabase(db);
		} catch (Exception e) {
			// 예외 발생 시 스택 트레이스 출력
			e.printStackTrace();
		}
	}
}
