package com.mongo.level1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SelectMongo3 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoCollection<Document> collection = db.getCollection("book");
           Document  doc = collection.find().first();
           System.out.println(doc.toJson());           
           
           FindIterable<Document>dlist = collection.find(Filters.gt("price", 10000));
           for(Document doc1 : dlist)
           		System.out.println(doc1.toJson());
           
          dlist = collection.find(Filters.eq("name", "javascript"));
           for(var doc1 : dlist)
           		System.out.println(doc1.toJson());
           
           dlist = collection.find(Filters.regex("name", "^ja"));
           for(var doc1 : dlist)
           		System.out.println(doc1.toJson());
           
          dlist =  collection.find(Filters.and(Filters.gt("price", 10000), Filters.lte("price", 20000)));
          for(Document doc1 : dlist)
         		System.out.println(doc1.toJson());
 
            mongoClient.close();
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
	}
}


