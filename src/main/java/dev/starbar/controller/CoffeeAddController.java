package dev.starbar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffees/add")
public class CoffeeAddController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("coffeeName");
		String size = req.getParameter("coffeeSize");
		int price =  Integer.parseInt(req.getParameter("coffeePrice"));
		
		Coffee newCoffee = new Coffee(name, size, price);
		
		CoffeeService service = new CoffeeService();
		service.addCoffeeMenu(newCoffee);
		
//		final String url = "/";
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
//	
//		dispatcher.forward(req, resp);
		
		resp.sendRedirect("http://localhost:8080/starbar/index.jsp");
	}

	

	
}
