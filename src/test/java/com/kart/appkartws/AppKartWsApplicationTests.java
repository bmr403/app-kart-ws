package com.kart.appkartws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppKartWsApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(AppKartWsApplicationTests.class); 
	
	@Test
	public void contextLoads() {
		logger.info("UNIT TEST STARTED ");
	}

}
