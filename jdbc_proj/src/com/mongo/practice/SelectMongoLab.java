package com.mongo.practice;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class SelectMongoLab {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        try (MongoClient mongoClient = new MongoClient();) {
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("avengers");
            FindIterable<Document> dlist = collection.find();

            for (var doc : dlist) {
                System.out.printf("%s 팀원의 나이는 %.0f입니다\n", doc.get("name"),
                        Double.parseDouble(doc.get("age").toString()));
                System.out.println("[좋아하는 책리스트]");
                for (Document book : (ArrayList<Document>) doc.get("book")) {
                    System.out.println("책 제목 : " + book.get("bookName"));
                    System.out.println("출판사 : " + book.get("publisher"));
                    System.out.println("장르 : " + book.get("genre"));
                }
                System.out.println("-----------------------------------");
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
