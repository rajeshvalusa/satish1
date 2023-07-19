Object class DEEP CLONING METHOD
=============================================================
package com.cisco;

public class Department implements Cloneable {
	public int did;
	public String dname;
	public Department(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + "]";
	}
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Object clone() throws CloneNotSupportedException
	{
		Department d=(Department) super.clone();
		return d;	
	}
     
}
========================================================
package com.cisco;

public class Employee implements Cloneable {
	private int eid;
	private String ename;
	private Department dep;
	private Student stu;

	public Employee(int eid, String ename, Department dep, Student stu) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dep = dep;
		this.stu = stu;
	}
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dep=" + dep + ", stu=" + stu + "]";
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Object clone() throws CloneNotSupportedException
	{
		Employee e=(Employee) super.clone();
		e.dep=(Department) e.dep.clone();
		e.stu=(Student) e.stu.clone();
		return e;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e=new Employee(1, "satish", new Department(100, "rajesh"),new Student(120, "raju"));
		Employee h=(Employee) e.clone();
		
		e.setEid(2);
		e.dep.setDname("ramesh");
		e.stu.setSname("naveen");
		System.out.println(e);
		System.out.println(h);

	}

}
==========================================================================
object class clone shallow cloning 
====================================
package com.cisco;

public class Student implements Cloneable {
     public int sid;
     public String sname;
	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
     public Object clone() throws CloneNotSupportedException
     {
		Student s=(Student) super.clone();
		return s;
     }
     
}
