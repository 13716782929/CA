package sg.edu.nus.goldlake.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.nus.goldlake.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("Select p from Product as p where p.name like CONCAT('%',:k,'%') ") //关键字搜索：将命名参数:k（即搜索关键字）包裹在百分号（%）之间，表示在category字段中搜索包含该关键字的所有记录。
			 public ArrayList<Product> //ArrayList而不是List
			SearchProductByName(@Param("k") String keyword);
			 
	@Query("Select p from Product as p where p.category like CONCAT('%',:k,'%') ") 
			 public ArrayList<Product> 
			SearchProductByCategory(@Param("k") String keyword);
}
