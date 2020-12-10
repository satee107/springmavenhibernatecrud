package fit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fit.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();	
        Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		//session.close();
	}

	@Override
	public void updateProduct(Product p) {
		Session session = this.sessionFactory.getCurrentSession();	
		 Transaction tx =session.beginTransaction();
		session.update(p);
		tx.commit();
		//session.close();

		
	}

	@Override
	public List<Product> listProduct() {
		List<Product> list = new ArrayList<Product>();
		Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
		list = session.createQuery("from Product").list();
		//session.close();

		return list;
	}

	@Override
	public Product getProductById(int id) {
		System.out.println("hi getproduct");
		Session session = this.sessionFactory.getCurrentSession();	
		 Transaction tx = session.beginTransaction();
		Product product = (Product) session.load(Product.class, new Integer(id));
		System.out.println(product.getName());
		tx.commit();
		//session.close();
		return product;
	}

	@Override
	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		 Transaction tx = session.beginTransaction();
		 System.out.println("withiin dao");
		Product product = new Product();
		product.setId(id);
		session.delete(product);
		
		tx.commit();
		//session.close();

		
		
	}

}
