package com.Product;

public class productPojo {
	private int pid;
	private String pname;
	private double pcost;
	private double pweight;
	private String pbrand;
	@Override
	public String toString() {
		return "pid=" + pid + ", pname=" + pname + ", pcost=" + pcost + ", pweight=" + pweight
				+ ", pbrand=" + pbrand;
	}
	public productPojo(int pid, String pname, double pcost, double pweight, String pbrand) {
		this.pid = pid;
		this.pname = pname;
		this.pcost = pcost;
		this.pweight = pweight;
		this.pbrand = pbrand;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPcost() {
		return pcost;
	}
	public void setPcost(double pcost) {
		this.pcost = pcost;
	}
	public double getPweight() {
		return pweight;
	}
	public void setPweight(double pweight) {
		this.pweight = pweight;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}

}
================================================================
package com.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.Dao.productDao;
import com.Product.productPojo;

public class productController {
	productDao pr=new productDao();

	public Set<productPojo> getAllproducts() throws IOException {
		Set<productPojo> sc=pr.getAllproducts();
		return sc;
	}

	public productPojo getBasedonID(int pid) throws IOException {
		productPojo s= pr.getBasedonId(pid);
		return s;
	}

	public Set<productPojo> getBasedonName(String pname) throws IOException {
		Set<productPojo> sc=pr.getBasedonName(pname);
		return sc;
	}

}
======================================================================
package com.Dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.Product.productPojo;

public class productDao {
	FileReader fr=null;
	BufferedReader br=null;
	public Set<productPojo> getAllproducts() throws IOException{
		Set<productPojo> set=new HashSet();
		fr=new FileReader("C:\\Users\\rajes\\OneDrive\\Documents\\slokam\\product.txt");
		br=new BufferedReader(fr);
		for(String h=br.readLine();h!=null;h=br.readLine()) {
			String[] n=h.split(",");
			productPojo pr=new productPojo(Integer.parseInt(n[0]),n[1],Double.valueOf(n[2]),Double.valueOf(n[3]),n[4]);
			set.add(pr);
		}
			
		return set;
		
	}
	public productPojo getBasedonId(int eid) throws IOException {
		fr=new FileReader("C:\\Users\\rajes\\OneDrive\\Documents\\slokam\\product.txt");
		br=new BufferedReader(fr);
		productPojo pr=null;
		for(String h=br.readLine();h!=null;h=br.readLine()) {
			String[] n=h.split(",");
			if(Integer.parseInt(n[0])==eid) {
			pr=new productPojo(Integer.parseInt(n[0]),n[1],Double.valueOf(n[2]),Double.valueOf(n[3]),n[4]);
			}
		}
		return pr;
		
	}
	
	public Set<productPojo> getBasedonName(String pname) throws IOException {
		Set<productPojo> set=new HashSet();
		fr=new FileReader("C:\\Users\\rajes\\OneDrive\\Documents\\slokam\\product.txt");
		br=new BufferedReader(fr);
		for(String h=br.readLine();h!=null;h=br.readLine()) {
			String[] n=h.split(",");
			if(n[1].equals(pname)) {
			productPojo pr=new productPojo(Integer.parseInt(n[0]),n[1],Double.valueOf(n[2]),Double.valueOf(n[3]),n[4]);
			set.add(pr);
		}
	}	
		return set;
	}

}
===================================================================================================
package com.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.Controller.productController;
import com.Product.productPojo;

public class test {

	public static void main(String[] args) throws IOException {
		productController pr=new productController();
		Scanner sc=new Scanner(System.in);
		System.out.println("gp: getall product details");
		System.out.println("bid: get product details based on id");
		System.out.println("bname: get product details based on name");
		String sd=sc.next();
		try {
			switch(sd) {
			case "gp" :
				Set<productPojo> set=pr.getAllproducts();
				Iterator<productPojo> sr=set.iterator();
				while(sr.hasNext()) {
					System.out.println(sr.next());
				}
				break;
			case "bid" :
				System.out.println("please enter id");
				int pid=sc.nextInt();			
				productPojo a=pr.getBasedonID(pid);
				System.out.println(a);
				break;
			case "bname" :
				System.out.println("please enter the pname");
				String pname=sc.next();
				Set<productPojo> s=pr.getBasedonName(pname);
				Iterator<productPojo> sm=s.iterator();
				while(sm.hasNext()) {
					System.out.println(sm.next());
				}
				break;
			default : System.out.println("not match");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
===========================================================================

