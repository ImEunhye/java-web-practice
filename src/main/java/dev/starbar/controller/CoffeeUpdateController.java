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

@WebServlet("/update")
public class CoffeeUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CoffeeService service = new CoffeeService();
		List<Coffee> coffees = service.findAll();

		final String url = "updateCoffeePage.jsp";

		RequestDispatcher dispatcher = req.getRequestDispatcher(url);

		req.setAttribute("list", coffees);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("coffeeId"));
		String name = req.getParameter("coffeeName");
		String size = req.getParameter("coffeeSize");
		int price = Integer.parseInt(req.getParameter("coffeePrice"));

		Coffee newCoffee = new Coffee(name, size, price);

		CoffeeService service = new CoffeeService();
		service.updateCoffeeMenu(id, newCoffee);
		
		resp.sendRedirect("http://localhost:8080/starbar/index.jsp");
		
	}

}
