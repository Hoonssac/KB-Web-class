package sec02;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;

import app.Database;

public class InsertOneTest {
	public static void main(String[] args) {
		MongoCollection<Document> collection = Database.getCollection("todo");

		// 새 문서를 생성하고 필들르 추가
		Document document = new Document();
		document.append("title", "MongoDB");
		document.append("desc", "MongoDB 공부하기");
		document.append("done", false);

		// 문서를 'todo' 컬렉션에 삽입
		InsertOneResult result = collection.insertOne(document);

		// 삽입된 문서 ID를 출력
		System.out.println("==> InsertOneResult : " + result.getInsertedId());

		// 데이터베이스 연결 닫기
		Database.close();
	}
}
