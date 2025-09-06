package com.example.myapplication.service;

import com.example.myapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private static List<Product> productList;
    private static Map<String,String> countryMap;
    private static Map<String,String> interestsMap;
    private static Map<Character,String> genderoption;
    static {
        productList=new ArrayList<>();
        //these are all hardcoded value
        productList.add(new Product("iPhone 16",100000.00,List.of("16MP Camera","6GB Ram","64GB Storage")));
        productList.add(   new Product("One plus14",35000.00,List.of("8MP Camera","$GB Ram","64GB Storage")));
        //first initialize the contrymap
        countryMap = new HashMap<>();
        countryMap.put("australia","Australia");
        countryMap.put("canada","Canada");
        countryMap.put("india","India");
        countryMap.put("south africa","South africa");
        //intialize the interestsmap
        interestsMap = new HashMap<>();
        interestsMap.put("writing","Writing");
        interestsMap.put("reading","Reading");
        interestsMap.put("cooking","Cooking");
        //intialize the genderoption
        genderoption = new HashMap<>();
        genderoption.put('m',"Male");
        genderoption.put('f',"Female");

    }
   //constructor
    public ProductService() {
        System.out.println("Inside product service");
    }

    //  private List<Product> getProducts() {
    //instant method
  public List<Product> getProducts() {
    //    return  List.of(new Product("iPhone 16",100000.00,List.of("16MP Camera","6GB Ram","64GB Storage")),
      //          new Product("One plus13",35000.00,List.of("8MP Camera","$GB Ram","64GB Storage")));
      return productList;

    }
    //instant method
    public Map<String,String> getCountries(){
        return countryMap;
    }
    public Map<String,String> getInterestsMap(){
        return interestsMap;
    }
    public Map<Character,String> getGenderoption(){
        return genderoption;
    }

}
