package com.mongo.level1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
public class SelectMongo4 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase db = mongoClient.getDatabase("edudb");
			MongoCollection<Document> collection = db.getCollection("datecoll");
			Document doc = collection.find().first();
			System.out.println(doc.toJson());

			FindIterable<Document> dlist = collection.find(Filters.eq("name", "ㅋㅋ"));
			for (var doc1 : dlist) {
				Document doc2 = doc1;
				System.out.println(doc2.get("dt"));
				Date d = (Date)doc2.get("dt");
				SimpleDateFormat sdf = new SimpleDateFormat ( "yyyy년 MM 월 dd일 HH시 mm분 ss초"); 
				System.out.println(sdf.format(d)); 
			}
			mongoClient.close();
		} catch (Exception exception) {
			System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
		}
	}
}
