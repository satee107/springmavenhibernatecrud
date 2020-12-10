package fit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.dao.ProductDao;
import fit.model.Product;
@Service
public class ProductServiceImpl implements ProductService{

	private ProductDao productdao;

	public void setProductdao(ProductDao productdao) {
		this.productdao = productdao;
	}

	@Override
	@Transactional
	public void addProduct(Product p) {
		productdao.addProduct(p);		
	}

	@Override
	@Transactional
	public void updateProduct(Product p) {
		productdao.updateProduct(p);		
	}

	@Override
	@Transactional
	public List<Product> listProduct() {
		return productdao.listProduct();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return productdao.getProductById(id);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
		productdao.removeProduct(id);		
	}

}
