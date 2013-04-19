package at.dpe.gotocon2013.bookstore.da;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestCaseSimpleMongoDBCalls {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void testAutowiring() {
		assertNotNull(this.mongoTemplate);
	}

	@Test
	public void testConnection() {
		
		this.mongoTemplate.getCollection("gibtssichernicht");
	}
	
	@Test
	public void testCreateCollection() {
		
		this.mongoTemplate.createCollection("irgendeinetestcollection");
		this.mongoTemplate.dropCollection("irgendeinetestcollection");
	}
}
