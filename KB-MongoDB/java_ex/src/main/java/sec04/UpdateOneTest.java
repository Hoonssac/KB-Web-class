package sec04;

import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import app.Database;

public class UpdateOneTest {
	public static void main(String[] args) {
		MongoCollection<Document> collection = Database.getCollection("users");

		String id = "6835582781c25221de8c216f";
		Bson query = eq("_id", new ObjectId(id));

		Bson updates = Updates.combine(
			Updates.set("name", "modify name"),
			Updates.currentTimestamp("lastUpdated")
		);

		UpdateResult result = collection.updateOne(query, updates);
		System.out.println("==> UpdateResult : " + result.getModifiedCount());

		Database.close();
	}
}
