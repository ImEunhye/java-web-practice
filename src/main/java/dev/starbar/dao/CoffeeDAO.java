package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev.starbar.model.Coffee;
import dev.starbar.util.DBUtils;

public class CoffeeDAO {

	public List<Coffee> findAll() {
		final String selectQuery = "SELECT * FROM coffee";
		List<Coffee> coffees = new ArrayList<>();

		try (Connection con = DBUtils.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final int price = rs.getInt("price");

				coffees.add(new Coffee(id, name, size, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coffees;
	}

	public int addCoffeeMenu(Coffee newCoffee) {
		final String insertQuery = "INSERT INTO coffee(name, size, price) VALUES (?,?,?) ";

		try (Connection con = DBUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(insertQuery);) {
			pstmt.setString(1, newCoffee.getName());
			pstmt.setString(2, newCoffee.getSize());
			pstmt.setInt(3, newCoffee.getPrice());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public void deleteCoffeeMenu(int id) {
		String deleteQuery = "DELETE FROM coffee WHERE id=?";

		try (Connection con = DBUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(deleteQuery);) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCoffeeMenu(int id, Coffee newCoffee) {
		String updateQuery = "UPDATE coffee SET name=?, size=?, price=? WHERE id=?";
		
		try(Connection con = DBUtils.getConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);) {

			pstmt.setString(1, newCoffee.getName()); // 1번째 물음표에는 todoNumber를 맵핑
			pstmt.setString(2, newCoffee.getSize());
			pstmt.setInt(3, newCoffee.getPrice());
			pstmt.setInt(4,id);
			
			pstmt.executeUpdate();
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
}
