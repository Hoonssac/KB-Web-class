package sec05;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;

import app.Database;

public class DeleteManyTest {
	public static void main(String[] args) {
		MongoCollection<Document> collection = Database.getCollection("users");
		int age = 15;
		Bson query = gt("age", age);
		DeleteResult result = collection.deleteMany(query);
		System.out.println("==> DeleteManyResult : " + result.getDeletedCount());
		Database.close();
	}
}
