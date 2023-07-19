package com.Write;

import java.util.Comparator;

public class productPojo implements Comparable<productPojo>{
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
	public productPojo() {
		// TODO Auto-generated constructor stub
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pbrand == null) ? 0 : pbrand.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pcost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pid;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		temp = Double.doubleToLongBits(pweight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		productPojo other = (productPojo) obj;
		if (pbrand == null) {
			if (other.pbrand != null)
				return false;
		} else if (!pbrand.equals(other.pbrand))
			return false;
		if (Double.doubleToLongBits(pcost) != Double.doubleToLongBits(other.pcost))
			return false;
		if (pid != other.pid)
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (Double.doubleToLongBits(pweight) != Double.doubleToLongBits(other.pweight))
			return false;
		return true;
	}
	@Override
	public int compareTo(productPojo s) {
		Integer s1=s.getPid();
		return s1.compareTo(this.getPid());
	}
	
	

}
================================================================================================
package com.Write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class writeProduct {

	public void writeOperation(productPojo p) throws IOException {
		FileWriter fw=new FileWriter("C:\\Users\\rajes\\OneDrive\\Documents\\slokam\\rajesh.txt",true);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.newLine();
		bw.write(p.getPid()+","+p.getPname()+","+p.getPcost()+","+p.getPweight()+","+p.getPbrand());
		
		System.out.println("completed");
		bw.close();
		fw.close();
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		writeProduct w=new writeProduct();
		productPojo p=new productPojo();
		System.out.println("please enter the product id");
		p.setPid(sc.nextInt());
		System.out.println("please enter the product name");
		p.setPname(sc.next());
		System.out.println("please enter the product cost");
		p.setPcost(sc.nextDouble());
		System.out.println("please enter the product weight");
		p.setPweight(sc.nextDouble());
		System.out.println("please enter the product brand");
		p.setPbrand(sc.next());
		w.writeOperation(p);
	}

}
==================================================================
