package fit.dao;

import java.util.List;

import fit.model.Product;

public interface ProductDao {

	public void addProduct(Product p);
	public void updateProduct(Product p);
	public List<Product> listProduct();
	public Product getProductById(int id);
	public void removeProduct(int id);
}
