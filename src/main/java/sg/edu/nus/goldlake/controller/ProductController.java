package sg.edu.nus.goldlake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.goldlake.interfacemethods.ProductInterface; 
import sg.edu.nus.goldlake.service.ProductImplementation;

@Controller
public class ProductController {
	 @Autowired//使用@Autowired注解自动注入ProductInterface类型的bean
	 private ProductInterface pservice; 
	
	 @Autowired//通过@Autowired注解的setter方法注入ProductImplementation的实例。
	 public void setProductService(ProductImplementation pserviceImpl) 
	{ 
		 this.pservice = pserviceImpl; //将传入的ProductImplementation实例赋值给控制器类的成员变量pservice。这样，pservice就被初始化为ProductImplementation的实例，可以在控制器的其他方法中使用。
	 } 
	 
	 @RequestMapping("/") //映射根路径/到getSearchPage方法，返回视图名searchProducts。
	 public String getSearchPage(Model model) {
		 return "searchProducts"; 
	 } 
	 
	 @RequestMapping(value="/all/product/searching") 
	 public String search(@RequestParam("keyword") String k, @RequestParam("searchtype") String t, Model model) {//映射路径/all/product/searching到search方法，接收两个请求参数keyword和searchtype和一个model参数。 
		 //@RequestParam("keyword") String k：从请求中获取名为keyword的参数，并将其赋值给变量k。@RequestParam("searchtype") String t：从请求中获取名为searchtype的参数，并将其赋值给变量t。
		 String name=new String("name");
		 String catagory=new String("category");
		 if(t.equals(name)){ //根据searchtype的值调用不同的搜索方法，并将结果添加到模型中，键为products
		 model.addAttribute("products", pservice.SearchProductByName(k));
		 }
		 else if(t.equals(catagory)){ 
		 model.addAttribute("products", pservice.SearchProductByCategory(k));
		 } 
		 else { 
		 return "error"; //如果searchtype的值既不是name也不是category，返回视图名error
		 } 
	 return "searchResults"; //返回视图名searchResults
	} 
	 
}
