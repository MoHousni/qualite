package com.sid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sid.dao.VoitureDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionAllocationApplicationTests {
	
	@Autowired
	VoitureDao voitureDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getVoitureTest() {
		assertEquals(false, voitureDao.findByEtat(false).get(0).isEtat());
	}

}
