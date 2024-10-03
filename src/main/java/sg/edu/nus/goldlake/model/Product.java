package sg.edu.nus.goldlake.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id; 
	 
	@Column(length = 20)
	private String name; 
	 
	private double retailPrice; 
	 
	@Column(length = 50)
	private String description; 
	 
	@Column(length = 10)
	private String category; 
	 
	@Column(length = 10)
	private String supplierId; 
	 
	public Product() {//无参构造函数
	 super();//调用调用了父类的无参构造方法。
	 } 
	
	public Product(String name, double retailPrice, 
	String description, String category, String supplierId) {
	 super();//调用了父类的无参构造方法。
	 this.name = name; 
	 this.retailPrice = retailPrice; 
	 this.description = description; 
	 this.category = category; 
	 this.supplierId = supplierId; 
	 } 
	 
	 
	 
		public int getId() {
		 return id; 
		 } 
		public void setId(int id) {
		 this.id = id; 
		 }
		public String getName() {
		 return name; 
		 } 
		public void setName(String name) {
		 this.name = name; 
		 } 
		public double getRetailPrice() {
		 return retailPrice; 
		 } 
		public void setRetailPrice(double retailPrice) {
		 this.retailPrice = retailPrice; 
		 } 
		public String getDescription() {
		 return description; 
		 } 
		public void setDescription(String description) {
		 this.description = description; 
		 } 
		public String getCategory() {
		 return category; 
		 } 
		public void setCategory(String category) {
		 this.category = category; 
		 } 
		public String getSupplierId() {
		 return supplierId; 
		 } 
		public void setSupplierId(String supplierId) {
		 this.supplierId = supplierId; 
		 } 
}
