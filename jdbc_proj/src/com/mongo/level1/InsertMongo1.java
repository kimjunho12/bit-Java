package com.mongo.level1;

import java.util.function.Consumer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class InsertMongo1 {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");

            Document doc = new Document("name", "spring").append("price", "30000");
            collection.insertOne(doc);

            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(final Document document) {
                    System.out.println(document.toJson());
                }
            };
            collection.find().forEach(printConsumer);
            mongoClient.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
