package com.mongo.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertMongo2 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");
            
            List<Document> documents = new ArrayList<Document>();
            for (int i = 1; i <= 10; i++) {
                documents.add(new Document("name", "book"+i).append("price", 10000*i));
            }
            collection.insertMany(documents);
            
            MongoCursor<Document>  cursor  = collection.find().iterator();
            while(cursor.hasNext()) {
            	Document doc1 = cursor.next();
            	System.out.println(doc1.get("name") + " : " + doc1.get("price"));           
            }      
            mongoClient.close();
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
	}
}
