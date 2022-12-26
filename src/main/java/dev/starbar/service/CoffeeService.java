package dev.starbar.service;

import java.util.List;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

public class CoffeeService {
	private CoffeeDAO coffeeDAO = new CoffeeDAO(); 
	
	public List<Coffee> findAll() {
		return coffeeDAO.findAll();
	}
	
	public int addCoffeeMenu(Coffee newCoffee) {
		return coffeeDAO.addCoffeeMenu(newCoffee);
	}

	public void deleteCoffeeMenu(int id) {
	 coffeeDAO.deleteCoffeeMenu(id);
	}

	public void updateCoffeeMenu(int id, Coffee newCoffee) {
		coffeeDAO.updateCoffeeMenu(id, newCoffee);
	}
}
