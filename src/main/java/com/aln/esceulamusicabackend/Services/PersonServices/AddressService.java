package com.aln.esceulamusicabackend.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aln.esceulamusicabackend.Data.Person.AddressData;
import com.aln.esceulamusicabackend.Model.Person.Address;
import com.aln.esceulamusicabackend.Model.Response.Response;

import java.util.List;

@Service
public class AddressService {

    @Autowired
   private AddressData addressData;


    public Response<Address> createAddress(Address address) {
        boolean success = addressData.addAddress(address);
        Response<Address> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("Address Created");
            response.setMessage("Address created successfully");

        } else {
            response.setStatus("error");
            response.setTitle("Address Creation Failed");
            response.setMessage("Failed to create address");
        }

        return  response;
    }

    public Response<Address> getAddressById(int id) {
        Address address = addressData.getAddressById(id);
        Response<Address> response = new Response<>();
        if (address != null) {
            response.setStatus("success");
            response.setTitle("Address Found");
            response.setMessage("Address retrieved successfully");
            response.setData(address);
        } else {
            response.setStatus("error");
            response.setTitle("Address Not Found");
            response.setMessage("No address found with the given ID");
        }
        return response;
    }

    public Response<String> updateAddress(Address address) {
        boolean success = addressData.updateAddress(address);
        Response<String> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("Address Updated");
            response.setMessage("Address updated successfully");
        } else {
            response.setStatus("error");
            response.setTitle("Address Update Failed");
            response.setMessage("Failed to update address");
        }
        return response;
    }

    public Response<String> deleteAddress(int id) {
        boolean success = addressData.deleteAddress(id);
        Response<String> response = new Response<>();
        if (success) {
            response.setStatus("success");
            response.setTitle("Address Deleted");
            response.setMessage("Address deleted successfully");
        } else {
            response.setStatus("error");
            response.setTitle("Address Deletion Failed");
            response.setMessage("Failed to delete address");
        }
        return response;
    }

    public Response<List<Address>> getAllAddresses() {
        List<Address> addresses = addressData.getAllAddresses();
        Response<List<Address>> response = new Response<>();
        if (addresses != null && !addresses.isEmpty()) {
            response.setStatus("success");
            response.setTitle("Addresses Retrieved");
            response.setMessage("Addresses retrieved successfully");
            response.setData(addresses);
        } else {
            response.setStatus("error");
            response.setTitle("No Addresses Found");
            response.setMessage("No addresses found in the database");
        }
        return response;
    }
}
