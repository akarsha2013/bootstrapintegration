package com.example.myapplication.controller;

import com.example.myapplication.model.Contact;
import com.example.myapplication.model.Product;
import com.example.myapplication.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


//controller class

@Controller
@AllArgsConstructor
public class HomeController {

    private final ProductService productService;

 //   public HomeController(Productservice productservice) {
 //       System.out.println("Inside HomeController");
 //       this.productservice = productservice;
//}

    //@RequestMapping("/home")
 @RequestMapping({" ","/home","/"})

 //handler method
    public String showPage(Model model){

     model.addAttribute("myname","akarsh");
     model.addAttribute("title","Home");
        return "mypage";

    }
    @GetMapping("/about-us")
    //handler method
      public String showAboutUsPage(Model model){
     model.addAttribute("title","About Us");
        return "aboutus";
    }

    @GetMapping("/contact-us")
    //handler method
    public String showContactUsPage(Model model){
        model.addAttribute("title","Contact Us");
        model.addAttribute("countries",productService.getCountries());
        model.addAttribute("contact",new Contact());
        model.addAttribute("interests",productService.getInterestsMap());
        model.addAttribute("genderOption",productService.getGenderoption());


        //model.addAttribute("display","false");
        return "contactus";
    }

    @GetMapping("/services")
    //handler method
    public String showServicesPage(Model model){
        model.addAttribute("title","Services");
        //create an array
        //String[] services={"Android app development","ios app development","web app development","web design","UI/UX development"};
        //create collection,arrylist
      /*  List<String> services= new ArrayList<>();
        services.add("Android app development");
        services.add("Ios app development");
        services.add("web app development");*/
        //List of collection
        List<String> services=List.of("Android app development","ios app development","web app development","web design","UI/UX development");
        model.addAttribute("services",services);
        return "services";
    }
    @GetMapping("/product")
    //handler method
    public String showProductPage(Model model, @RequestParam(required = false,name = "name",defaultValue = "UnknownProduct") String productName,
                                  @RequestParam(required = false,name = "price",defaultValue = "00.0")double price){
     System.out.println("Receiving the parameter from url :::" +productName);
        System.out.println("Receiving the parameter from url :::" +price);
        model.addAttribute("title","product");
        model.addAttribute("appname",productName);
        List<Product> products=productService.getProducts();
        model.addAttribute("products",products);

        return "product";

    }

    //private List<Product> getProducts() {
    // List<Product> productList=new ArrayList<>();
     //   Product p = new Product("iPhone 16",100000.00,List.of("16MP Camera","6GB Ram","64GB Storage"));
      //  productList.add(p);
     //   Product p1 = new Product("One plus13",35000.00,List.of("8MP Camera","$GB Ram","64GB Storage"));
      //  productList.add(p1);

    //    return  List.of(new Product("iPhone 16",100000.00,List.of("16MP Camera","6GB Ram","64GB Storage")),
    // new Product("One plus13",35000.00,List.of("8MP Camera","$GB Ram","64GB Storage")));


 //}


    // productname is nothing but variable name
    @GetMapping("/product/{productname}/details")
    //handler method
    public String showProductDetailsPage(Model model, @PathVariable("productname")String productName) {
     System.out.println("Product Name :::"+productName);
     model.addAttribute("title","Product Details");
     model.addAttribute("productId",productName);
        return "product-details";

    }
    @PostMapping ("/contactprocess")
    //handler method
    public String processContactForm(Model model, HttpServletRequest request, @ModelAttribute Contact contact , RedirectAttributes attributes) {
       // String fullname = request.getParameter("fullname");
      //  String country = request.getParameter("country");
      //  System.out.println("Printin country:::"+country);
      //  System.out.println("Printin full name:::"+fullname);
     //   model.addAttribute("fullname",fullname);
     //   model.addAttribute("country",country);
        //model.addAttribute("display","true");
       // return "redirect:contact-us";
        attributes.addFlashAttribute("data",contact);
        System.out.println("Printing contact object::"+contact);
       // return  "contactus";
        return "redirect:/" +
                "contact-us";

    }

}
