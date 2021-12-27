package com.mongo.level1;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectMongo1 {

    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

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

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            MongoDatabase db = mongoClient.getDatabase("edudb");                // DB 지정
            MongoCollection<Document> collection = db.getCollection("book");    // Collection 지정
            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
            System.out.println("--------------------------------");
            cursor = collection.find().iterator();                              // Cursor 활용
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.get("name") + " : " + doc.get("price"));
            }
            System.out.println("--------------------------------");
            Consumer<Document> printConsumer = new Consumer<Document>() {       // Consumer 활용
                @Override
                public void accept(final Document document) {
                    System.out.println(document.toJson());
                }
            };
            collection.find().forEach(printConsumer);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }


        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {
            System.out.println("--------------------------------");

            MongoDatabase db = mongoClient.getDatabase("edudb");             // DB 지정
            MongoCollection<Document> collection = db.getCollection("book"); // Collection 지정
            Document doc = collection.find().first();
            System.out.println(doc.toJson());                                // Json 형식 출력
            System.out.println("--------------------------------");

            FindIterable<Document> dlist = collection.find(Filters.gt("price", 10000)); // Filters 사용
            for (Document doc1 : dlist)
                System.out.println(doc1.toJson());
            System.out.println("--------------------------------");

            dlist = collection.find(Filters.eq("name", "javascript"));
            for (var doc1 : dlist)
                System.out.println(doc1.toJson());
            System.out.println("--------------------------------");

            dlist = collection.find(Filters.regex("name", "^ja"));
            for (var doc1 : dlist)
                System.out.println(doc1.toJson());
            System.out.println("--------------------------------");

            dlist = collection.find(Filters.and(Filters.gt("price", 10000), Filters.lte("price", 20000)));
            for (Document doc1 : dlist)
                System.out.println(doc1.toJson());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());
        }

    }
}
