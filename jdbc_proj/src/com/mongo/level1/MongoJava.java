package com.mongo.level1;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoJava {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            System.out.println("접속 성공--- ");
            MongoIterable<String> dblist = mongoClient.listDatabaseNames();
            System.out.println("[데이터베이스 리스트]");
            for (String name : dblist)
                System.out.println(name);
            MongoDatabase db = mongoClient.getDatabase("edudb");
            MongoIterable<String> clist = db.listCollectionNames();
            System.out.println("[edudb 데이터베이스의 컬렉션 리스트]");
            for (String name : clist)
                System.out.println(name);
            mongoClient.close();
        } catch (Exception exception) {
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }
}
