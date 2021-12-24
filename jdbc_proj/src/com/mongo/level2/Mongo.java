package com.mongo.level2;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Mongo {
	public static MongoClient connect() {
		MongoClient mongoClient = null;
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
	    try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));  
        } catch (Exception exception) {
             System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
	    return mongoClient;
	}
	public static void close(MongoClient mongoClient) {
		mongoClient.close();
	}
}