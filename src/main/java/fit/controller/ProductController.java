package fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fit.model.Product;
import fit.service.ProductService;

@Controller
public class ProductController {
	
	ProductService productservice;
	
	@Autowired(required=true)
	@Qualifier(value="productservice")
	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String openindex() {
    	return "index";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listproducts", this.productservice.listProduct());
		return "productform";
	}
    
  //For add and update person both
  	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
  	public String addProduct(@ModelAttribute("product") Product p){
  		
  		if(p.getId() == 0){
  			//new person, add it
  			this.productservice.addProduct(p);
  		}else{
  			//existing person, call update
  			this.productservice.updateProduct(p);
  		}
  		
  		return "redirect:/products";
  		
  	}
  	
  	
  	@RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
		System.out.println("withn delete controller");
        this.productservice.removeProduct(id);
        return "redirect:/products";
    }
  	
  	
  	 @RequestMapping("/edit/{id}")
     public String editProduct(@PathVariable("id") int id, Model model){
         model.addAttribute("product", this.productservice.getProductById(id));
         model.addAttribute("listproducts", this.productservice.listProduct());
         return "productform";
     }


	
    
    
    
    
    

}
