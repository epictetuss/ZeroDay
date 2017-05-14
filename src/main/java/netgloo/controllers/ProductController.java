package netgloo.controllers;

import netgloo.entity.Product;

import netgloo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/user")
public class ProductController {

  @Autowired
  private ProductServiceImpl productServiceImpl;

  @RequestMapping(value="/delete", method = RequestMethod.DELETE, produces = "application/json")
  @ResponseBody
  public String delete(int id) {
    try {
      Product product = new Product(id);
      productServiceImpl.delete(product);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }

  @RequestMapping(value="/update", method = RequestMethod.PUT, produces = "application/json")
  @ResponseBody
  public void update(int id,String category, double discountPrice, double price, String subtitle, String title)
  {
    try
    {
      Product product = new Product(id,title, subtitle, price, discountPrice, category);
      productServiceImpl.update(product);
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  
 /* @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = productDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }*/

  @RequestMapping(value="/getAllProducts", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<Product> getAll(){
    try {
      return productServiceImpl.getAllProducts();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      return null;
    }
  }


  @RequestMapping(value="/save", method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public String create(String category, double discountPrice, double price, String subtitle, String title) {
    try {
      Product product = new Product(title,subtitle,price,discountPrice,category);
      productServiceImpl.save(product);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

}