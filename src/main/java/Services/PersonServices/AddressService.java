package Services.PersonServices;
import Data.Person.AddressData;
import Model.Person.Address;
import Model.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
   private AddressData addressData;


    public Response createAddress(Address address) {
        boolean success = addressData.addAddress(address);
        Response response = new Response();
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

}
