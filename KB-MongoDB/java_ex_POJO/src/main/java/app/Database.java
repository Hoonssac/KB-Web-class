package app;

import static com.mongodb.MongoClientSettings.*;
import static org.bson.codecs.configuration.CodecRegistries.*;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Database {
	static MongoClient client;
	static MongoDatabase database;
	static {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

		ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");
		client = MongoClients.create(connectionString);
		database = client.getDatabase("todo_db").withCodecRegistry(pojoCodecRegistry);
	}

	public static void close() {
		client.close();
	}

	public static MongoDatabase getDatabase() {
		return database;
	}

	// 특정 컬렉션을 Document 형식으로 반환하는 메서드
	public static MongoCollection<Document> getCollection(String colName) {
		MongoCollection<Document> collection = database.getCollection(colName);
		return collection;
	}

	public static <T> MongoCollection<T> getCollection(String colName, Class<T> clazz) {
		MongoCollection<T> collection = database.getCollection(colName, clazz);
		return collection;
	}
}
