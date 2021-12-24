package com.mongo.level1;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class SelectMongo1 {
    public static void main(String[] args) {
        try (MongoClient mongoClient = new MongoClient("localhost", 27017);) {  // DB 연결 설정
            MongoDatabase db = mongoClient.getDatabase("edudb");                // DB 지정
            MongoCollection<Document> collection = db.getCollection("book");    // Collection 지정
            MongoCursor<Document> cursor = collection.find().iterator();        // Cursor로 결과 저장
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }
}
