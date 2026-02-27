package com.assignment.jdbcphones.dao;
import com.assignment.jdbcphones.connection.DBConnection;
import com.assignment.jdbcphones.entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {

    @Override
    public void addPhone(Phone p) {
        String sql = "insert into phone(id,name,cost,brand,category) values(?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getCost());
            ps.setString(4, p.getBrand());
            ps.setString(5, p.getCategory());

            ps.executeUpdate();
            System.out.println("Phone Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> list = new ArrayList<>();
        String sql = "select * from phone";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToPhone(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Phone findPhoneById(int id) {
        String sql = "select * from phone where id=?";
        Phone p = null;

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = mapToPhone(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void updatePhone(Phone p) {
        String sql = "update phone set name=?, cost=?, brand=?, category=? where id=?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getCost());
            ps.setString(3, p.getBrand());
            ps.setString(4, p.getCategory());
            ps.setInt(5, p.getId());

            ps.executeUpdate();
            System.out.println("Phone Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePhone(int id) {
        String sql = "delete from phone where id=?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Phone Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Phone> sortByName() {
        return executeQuery("select * from phone order by name");
    }

    @Override
    public List<Phone> sortByCost() {
        return executeQuery("select * from phone order by cost");
    }

    @Override
    public List<Phone> sortByCategory() {
        return executeQuery("select * from phone order by category");
    }

    @Override
    public List<Phone> filterByCategory(String category) {
        return executeQueryWithParam("select * from phone where category=?", category);
    }

    @Override
    public List<Phone> filterByCost(double min, double max) {
        List<Phone> list = new ArrayList<>();
        String sql = "select * from phone where cost between ? and ?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToPhone(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<Phone> executeQuery(String sql) {
        List<Phone> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToPhone(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private List<Phone> executeQueryWithParam(String sql, String param) {
        List<Phone> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, param);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapToPhone(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Phone mapToPhone(ResultSet rs) throws SQLException {
        return new Phone(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("cost"),
                rs.getString("brand"),
                rs.getString("category")
        );
    }
}