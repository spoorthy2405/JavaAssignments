package com.assignment.jdbcproducts.dao;
import com.assignment.jdbcproducts.connection.DataBaseConnection;
import com.assignment.jdbcproducts.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void addProduct(Product p) {

        String sql = "insert into product(id,name,price,category,quantity) values(?,?,?,?,?)";

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getCategory());
            ps.setInt(5, p.getQuantity());

            ps.executeUpdate();
            System.out.println("Product Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return executeQuery("select * from product");
    }

    @Override
    public Product findById(int id) {

        String sql = "select * from product where id=?";
        Product p = null;

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = mapToProduct(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public void updateProduct(Product p) {

        String sql = "update product set name=?, price=?, category=?, quantity=? where id=?";

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getCategory());
            ps.setInt(4, p.getQuantity());
            ps.setInt(5, p.getId());

            ps.executeUpdate();
            System.out.println("Product Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {

        String sql = "delete from product where id=?";

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Product Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> sortByName() {
        return executeQuery("select * from product order by name");
    }

    @Override
    public List<Product> sortByPrice() {
        return executeQuery("select * from product order by price");
    }

    @Override
    public List<Product> sortByCategory() {
        return executeQuery("select * from product order by category");
    }

    @Override
    public List<Product> filterByCategory(String category) {

        List<Product> list = new ArrayList<>();
        String sql = "select * from product where category=?";

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Product> filterByPrice(double min, double max) {

        List<Product> list = new ArrayList<>();
        String sql = "select * from product where price between ? and ?";

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<Product> executeQuery(String sql) {

        List<Product> list = new ArrayList<>();

        try (Connection con = DataBaseConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToProduct(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private Product mapToProduct(ResultSet rs) throws SQLException {

        return new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("category"),
                rs.getInt("quantity")
        );
    }
}
