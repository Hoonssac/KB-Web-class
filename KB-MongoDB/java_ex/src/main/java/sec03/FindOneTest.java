package sec03;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;

import app.Database;

public class FindOneTest {
	public static void main(String[] args) {
		MongoCollection<Document> collection = Database.getCollection("todo");

		String id = "6835509850b9470634ca64b1";

		// Filters.eq를 import 후 사용
		Bson query = eq("_id", new ObjectId(id));

		// first는 가장 먼저 찾은 문서 하나 반환
		Document doc = collection.find(query).first();
		System.out.println("==> findByIdResult : " + doc);
		Database.close();
	}
}
