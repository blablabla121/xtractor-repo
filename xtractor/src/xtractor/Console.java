package xtractor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.io.fs.FileUtils;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
//@Transactional
public class Console {
	final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Console.class);
	public static File dbDir = null;
	public static String dbLocation;
	public static GraphDatabaseService db;
	
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		dbLocation = args[0];
		dbDir = new File(args[0]);
		
		if (dbDir.exists()){
			logger.info("Deleting an old database");
			FileUtils.deleteRecursively(dbDir);
		}
		
		logger.info("Creating a database...");
		db = new GraphDatabaseFactory().newEmbeddedDatabase(dbDir);
		
            
		AnnotationConfigApplicationContext context =
		    new AnnotationConfigApplicationContext(Neo4jConfig.class);
			
		Neo4jOperations template = new Neo4jTemplate(context.getBean(Session.class));
			
			
		Person person1 = new Person("dsada");
		Person person2 = new Person("wwww");
		Person person3 = new Person("hhhh");
	
		template.save(person1);
		template.save(person2);
		template.save(person3);
		context.close();			
     
	}
	
	
} 
