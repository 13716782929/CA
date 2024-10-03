package sg.edu.nus.goldlake.test;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.nus.goldlake.model.Product;
import sg.edu.nus.goldlake.repository.ProductRepository;

@SpringBootTest//声明了一个测试类ProductDataCreation，并使用@SpringBootTest注解表明这是一个Spring Boot测试类
public class ProductDataCreation {
	@Autowired//自动注入ProductRepository类型的bean。
	private ProductRepository prepo; 
	 
	@Test//使用@Test注解声明一个测试方法conTextLoad。
	void conTextLoad() {
		 //创建了四个Product对象，分别是p11、p12、p13和p14，并初始化它们的属性。
		 Product p11 = new Product("Express Antique", 
		4000, "Elegant Antique ", "Antique", "NUS");
		 Product p12 = new Product("Aspire Antique", 
		5000, " ", "Antique", "NUS");
		 Product p13 = new Product("Loyal Antique", 
		6000, " ", "Antique","ISS");
		 Product p14 = new Product("Polo", 3000, 
		"Delicious taste", "Sweet", "SOC");
		 
		 // 使用ProductRepository的save方法将这四个Product对象保存到数据库中。
		 prepo.save(p11);
		 prepo.save(p12);
		 prepo.save(p13);
		 prepo.save(p14);
	 } 
}
