package dev.starbar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.starbar.model.Coffee;
import dev.starbar.service.CoffeeService;

@WebServlet("/coffees")
public class CoffeeListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeService service = new CoffeeService();
		List<Coffee> coffees = service.findAll();
		
		System.out.println(coffees);
		
		final String url = "coffeeList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		request.setAttribute("list", coffees);
		dispatcher.forward(request, response);
	}
}
