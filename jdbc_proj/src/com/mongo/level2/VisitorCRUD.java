package com.mongo.level2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class VisitorCRUD {
	public boolean c(Scanner scan) {
		boolean result = false;
		MongoClient mongoClient = Mongo.connect();
		MongoDatabase db = mongoClient.getDatabase("edudb");
		MongoCollection<Document> collection = db.getCollection("visitor");
		System.out.println(collection);
		try  {
			while (true) {
				System.out.print("ID를 숫자로  입력하세요 : ");
				int id = Integer.parseInt(scan.nextLine());
				System.out.print("작성자 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("글의 내용을 입력하세요 : ");
				String memo = scan.nextLine();

				Document doc = new Document("_id", id)
						.append("name", name)
						.append("writeDate",  new Date())
	                    .append("memo",memo);
	            collection.insertOne(doc);
				System.out.println("visitor 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				}
				break;
			}
			result = true;
		} catch (Exception se) {
			System.out.println(se);
		}
		Mongo.close(mongoClient);
		return result;
	}

	public List<VisitorVO> r() {
		MongoClient mongoClient = Mongo.connect();
		MongoDatabase db = mongoClient.getDatabase("edudb");
		MongoCollection<Document> collection = db.getCollection("visitor");
		List<VisitorVO> vlist = null;
		try {
			MongoCursor<Document>  cursor = collection.find().iterator();
			vlist = new ArrayList<VisitorVO>();
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				VisitorVO vo = new VisitorVO();
				vo.setId(doc.getInteger("_id"));
				vo.setName(doc.getString("name"));
				vo.setWriteDate(doc.getDate("writeDate").toString());
				vo.setMemo(doc.getString("memo"));
				vlist.add(vo);
			}
		} catch (Exception se) {
			System.out.println(se);
		}
		Mongo.close(mongoClient);
		return vlist;
	}

	public boolean u(Scanner scan, int id) {
		boolean result = false;
		MongoClient mongoClient = Mongo.connect();
		MongoDatabase db = mongoClient.getDatabase("edudb");
		MongoCollection<Document> collection = db.getCollection("visitor");
		try {
			System.out.print("수정할 작성자 이름을 입력하세요.(없으면 그냥 엔터) : ");
			String name = scan.nextLine();
			if (name != null && name.length() != 0)
				collection.updateOne(Filters.eq("_id", id), Updates.set("name", name));	
			System.out.print("수정할 글의 내용을 입력하세요.(없으면 그냥 엔터) : ");
			String memo = scan.nextLine();
			if (name != null && name.length() != 0)
				collection.updateOne(Filters.eq("_id", id), Updates.set("memo", memo));	
			result = true;
		} catch (Exception se) {
			System.out.println(se);
		}
		Mongo.close(mongoClient);
		return result;
	}

	public boolean d(int id) {
		boolean result = false;
		MongoClient mongoClient = Mongo.connect();
		MongoDatabase db = mongoClient.getDatabase("edudb");
		MongoCollection<Document> collection = db.getCollection("visitor");
		try  {
			Bson filter = Filters.eq("_id", id);
            collection.deleteOne(filter);
			result = true;
		} catch (Exception se) {
			System.out.println(se);
		}
		Mongo.close(mongoClient);
		return result;
	}
}
