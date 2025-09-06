package in.akarsh.studentregister.controller;


import in.akarsh.studentregister.entity.Address;
import in.akarsh.studentregister.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController1 {

    private final AddressRepository addressRepository;
 //   private final EmployeeRepository1 employeeRepository1;

  //  public ResponseEntity<?> saveAddress1(@RequestBody AddressDTO addressDTO){
    //    return null;
    @GetMapping
    public List<Address> getAllAddress(){
        return addressRepository.findAll();


    }
}
