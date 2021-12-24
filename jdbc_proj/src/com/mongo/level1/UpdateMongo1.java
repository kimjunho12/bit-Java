package com.mongo.level1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class UpdateMongo1 {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        try {
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");

            collection.updateOne(Filters.eq("name", "spring"), Updates.set("price", 29999));    // Filter : 수정할 도큐먼트 정보, Updates : 바꿀 내용
            collection.updateOne(Filters.eq("name", "spark"), Updates.inc("price", 11));        // Updates.inc : 기존 값에 추가 (+= 같은 기능)
            MongoCursor<Document> cursor = collection.find().iterator();
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
