package com.sid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.beans.Voiture;
import com.sid.dao.VoitureDao;

@RestController
@CrossOrigin("*")
public class VoitureController {
	
	@Autowired
	private VoitureDao voitureDao;
	
	@RequestMapping(value="/listVoitures", method=RequestMethod.GET)
	public List<Voiture> getAllCars(){
		return voitureDao.findAll();
	}
	
	@RequestMapping(value="/listFreeCars", method=RequestMethod.GET)
	public List<Voiture> getFreeCars(){
		return voitureDao.findByEtat(false);
	}
	
}
