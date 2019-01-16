package com.sid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sid.beans.Voiture;
import com.sid.dao.LouerDao;
import com.sid.dao.VoitureDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionAllocationApplicationTests {
	
	@Autowired
	VoitureDao voitureDao;
	
	@Autowired
	LouerDao louerDao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getVoitureTest() {
		assertEquals(false, voitureDao.findByEtat(false).get(0).isEtat());
	}
	
	@Test
	public void getLouer() {
		Voiture voiture = new Voiture("125687-A-26", "focus 2016", "Diesel", "Automatic", "ford", 140000, 300, true, "01.png");
		assertEquals(voiture.getMatVoiture(), louerDao.findByEtatDeRentEtVoiture(voiture).getPk().getVoiture().getMatVoiture());
	}

}
