package sg.edu.nus.goldlake.interfacemethods;

import sg.edu.nus.goldlake.model.Product;

import java.util.List;

public interface ProductInterface {

	public boolean saveProduct(Product product);//接口方法————只创建方法名、输入值、返回类型，不规定具体方法操作
	public List<Product> SearchProductByName(String name);
	public List<Product> SearchProductByCategory(String category);
}
