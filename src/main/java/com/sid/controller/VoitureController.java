package com.sid.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sid.beans.Calendrie;
import com.sid.beans.Louer;
import com.sid.beans.Voiture;
import com.sid.dao.LouerDao;
import com.sid.dao.VoitureDao;

@RestController
@CrossOrigin("*")
public class VoitureController {
	
	@Autowired
	private VoitureDao voitureDao;
	
	@Autowired
	private LouerDao louerDao;
	
	@GetMapping(value="/listVoitures")
	public List<Voiture> getAllCars(){
		return voitureDao.findAll();
	}
	
	@GetMapping(value="/listFreeCars")
	public List<Voiture> getFreeCars(){
		return voitureDao.findByEtat(false);
	}
	
	@RequestMapping(value="/rentCar", method=RequestMethod.POST)
	public boolean rentCar(@RequestBody Louer louer) {
		
		Calendrie calendrie = new Calendrie(LocalDate.now(), LocalDate.now().plusDays(louer.getNbrJour()));
		louer.setCalendrie(calendrie);
		try {
			louerDao.save(louer);
			Voiture voiture = louer.getVoiture();
			voiture.setEtat(true);
			voitureDao.save(voiture);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	@RequestMapping(value="/freeTheCar", method=RequestMethod.PUT)
	public boolean freeTheCar(@RequestBody Louer louer) {
		Voiture voiture = louer.getVoiture();
		if(voiture != null) {
			voiture.setEtat(false);
			louer.setEtatDeRent(false);
			louerDao.save(louer);
			voitureDao.save(voiture);
			return true;
		}
		return false;
	}
	
}
