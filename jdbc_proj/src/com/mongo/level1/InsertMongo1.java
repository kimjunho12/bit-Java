package com.mongo.level1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class InsertMongo1 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");
            
           Document doc = new Document("name", "spring")
                    .append("price", "30000");
            collection.insertOne(doc);
            
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


