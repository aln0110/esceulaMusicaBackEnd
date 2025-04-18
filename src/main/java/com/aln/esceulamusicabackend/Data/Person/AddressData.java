package com.aln.esceulamusicabackend.Data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aln.esceulamusicabackend.Model.Person.Address;

import java.util.List;

@Repository
public class AddressData {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addAddress(Address address) {
        String sql = "INSERT INTO [argyranthemum].[person].[tbAddress] (id_persona, province, canton, district, full_address, status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, address.getIdPerson(), address.getProvince(), address.getCanton(), address.getDistrict(), address.getFullAddress(), address.isStatus());
            return true;
        } catch (Exception e) {
            System.out.println("Error adding address: " + e.getMessage());
            return false;
        }
    }

    public boolean updateAddress(Address address) {
        String sql = "UPDATE [argyranthemum].[person].[tbAddress] SET id_persona = ?, province = ?, canton = ?, district = ?, full_address = ?, status = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, address.getIdPerson(), address.getProvince(), address.getCanton(), address.getDistrict(), address.getFullAddress(), address.isStatus(), address.getId());
            return true;
        } catch (Exception e) {
            System.out.println("Error updating address: " + e.getMessage());
            return false;
        }
    }

    public boolean logicalDeleteAddress(int id) {
        String sql = "UPDATE [argyranthemum].[person].[tbAddress] SET status = false WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println("Error logically deleting address: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteAddress(int id) {
        String sql = "DELETE FROM [argyranthemum].[person].[tbAddress] WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting address: " + e.getMessage());
            return false;
        }
    }

    public Address getAddressById(int id) {
        String sql = "SELECT * FROM person.tbAddress WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setIdPerson(rs.getInt("id_persona"));
                address.setProvince(rs.getString("province"));
                address.setCanton(rs.getString("canton"));
                address.setDistrict(rs.getString("district"));
                address.setFullAddress(rs.getString("full_address"));
                address.setStatus(rs.getBoolean("status"));
                return address;
            });
        } catch (Exception e) {
            System.out.println("Error finding address by id: " + e.getMessage());
            return null;
        }
    }

    public List<Address> getAllAddresses() {
        String sql = "SELECT * FROM person.tbAddress";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setIdPerson(rs.getInt("id_persona"));
                address.setProvince(rs.getString("province"));
                address.setCanton(rs.getString("canton"));
                address.setDistrict(rs.getString("district"));
                address.setFullAddress(rs.getString("full_address"));
                address.setStatus(rs.getBoolean("status"));
                return address;
            });
        } catch (Exception e) {
            System.out.println("Error retrieving all addresses: " + e.getMessage());
            return null;
        }
    }


}
