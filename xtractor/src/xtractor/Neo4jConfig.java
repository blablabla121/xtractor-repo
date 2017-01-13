package xtractor;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;




@Configuration

public class Neo4jConfig extends Neo4jConfiguration{
	

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
		config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver")
		.setURI("file:///" + Console.dbLocation + ".db");
		
		return config;
	}
	
	
	@Override
	@Bean
    public SessionFactory getSessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory(getConfiguration(), "xtractor");
    }
	
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return Console.db; //thats the DatabaseService I use. 
	}
	
	@Bean
	//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception{
		return super.getSession();
	}
	
	
	
	@Bean
	public Neo4jOperations neo4jTemplate() throws Exception{
		return new Neo4jTemplate(getSession());
	}

}
