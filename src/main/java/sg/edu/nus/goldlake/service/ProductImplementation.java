package sg.edu.nus.goldlake.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;////声明事务

import sg.edu.nus.goldlake.interfacemethods.ProductInterface; 
import sg.edu.nus.goldlake.model.Product;
import sg.edu.nus.goldlake.repository.ProductRepository;

@Service//@Service注解表明这是一个服务类。
@Transactional//@Transactional注解表明该类中的方法是事务性的。作用是确保事务之间不会互相干扰。当方法抛出未检查异常（如 RuntimeException）时，事务会自动回滚，确保数据的一致性
public class ProductImplementation implements ProductInterface {//ProductImplementation类实现了ProductInterface接口。
	 
	@Autowired
	 ProductRepository prepo; //创建实例
	 
	 @Override//重写方法，它是一个编译时检查，确保方法签名正确。
	 @Transactional//声明事务
	 public boolean saveProduct(Product product) {
	 if (prepo.save(product) != null) 
	 return true; 
	 else
	 return false; 
	 } 
	 
	 @Override
	 @Transactional
	 public List<Product> SearchProductByName(String name) {
		 return prepo.SearchProductByName(name);//根据产品名称搜索产品。
	 } 
	 
	 @Override
	 @Transactional
	 public List<Product> SearchProductByCategory(String category) {
		 return prepo.SearchProductByCategory(category);//根据产品类别搜索产品
	 } 
	 
	
	
	
}
