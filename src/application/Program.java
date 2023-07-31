package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
			
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("=== Test 2: seller findByDepartmentId ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);	
		}
		
		System.out.println("=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);	
		}
		
		System.out.println("=== Test 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@greg.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("=== Test 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Blue");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("=== Test 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("User " + id + " deleted.");

		System.out.println("=== Test 7: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== Test 8: department findAll ===");
		List<Department> listDepartments = departmentDao.findAll();
		for (Department obj : listDepartments) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 9: department insert ===");
		Department newDepartment = new Department(null, "Shoes");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("=== Test 10: department update ===");
		department = departmentDao.findById(1);
		department.setName("Bikes");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		sc.close();
	}
	
}
