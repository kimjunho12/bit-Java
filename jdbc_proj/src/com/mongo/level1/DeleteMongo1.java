package com.mongo.level1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DeleteMongo1 {

    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");
            Bson filter = Filters.eq("name", "book1");
            collection.deleteOne(filter);       // 하나만 삭제
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document doc1 = cursor.next();
                System.out.println(doc1.get("name") + " : " + doc1.get("price"));
            }
            filter = Filters.gt("price", 50000);
            collection.deleteMany(filter);      // 여러 도큐먼트 삭제
            cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document doc1 = cursor.next();
                System.out.println(doc1.get("name") + " : " + doc1.get("price"));
            }
            mongoClient.close();
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
}
