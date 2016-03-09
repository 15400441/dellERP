package com.hkbu.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkbu.dao.CustomerDao;
import com.hkbu.domain.Components;
import com.hkbu.domain.ComponentsType;
import com.hkbu.domain.Dep;
import com.hkbu.domain.Emp;
import com.hkbu.domain.EmpRole;
import com.hkbu.domain.POrder;
import com.hkbu.domain.POrderdetail;
import com.hkbu.domain.SOrder;
import com.hkbu.domain.SOrderdetail;
import com.hkbu.domain.Supplier;
import com.hkbu.domain.Transaction;
import com.hkbu.service.CustomerService;

public class Generator
{
	private Class clazz;
	private String b;
	private String l;
	private String s;
	private String pkg;
	private String rootDir;

	/*
	 * public static void main(String[] args) throws IOException { //EmpModel,RoleModel,ResModel,MenuModel //SupplierModel,GoodsTypeModel,GoodsModel //OrderModel,OrderDetailModel //StoreModel,StoreDetailModel,StoreOperModel //new Generator(StoreOperModel.class); System.out.println("struts.xml未配置"); System.out.println("hbm.xml未配置关系"); System.out.println("QueryModel未添加范围字段");
	 * System.out.println("DaoImpl未添加查询条件的实现"); }
	 */

	public Generator(Class clazz) throws IOException
	{
		this.clazz = clazz;
		// -1.数据初始化
		dataInit();
		// 0.生成所有要使用的目录
		generatorDirectory();
		// 1.QueryModel
		generatorQueryModel();

		// 3.Dao
		generatorDao();
		// 4.Impl
		generatorDaoImpl();
		// 5.Ebi
		generatorService();
		// 6.Ebo
		generatorServiceImpl();
		// 7.Action
		generatorController();
		// 8.applicationContext.xml

	}

	private void generatorController() throws IOException
	{
		// 1.创建文件
		File f = new File("src/" + rootDir + "/controller/" + b + "Controller.java");

		if (f.exists())
		{
			System.out.println(b+"Controller already existed");
			return;
		}

		f.createNewFile();
		// 2.绑定IO流
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		// 3.写内容
		bw.write("package " + pkg + ".controller;" + "\r\n" + "" + "\r\n" 
		        + "import javax.annotation.Resource;" + "\r\n" + "" + "\r\n" 
		        + "import org.springframework.stereotype.Controller;" + "\r\n" + ""
		        + "import org.springframework.ui.Model;" + "\r\n" + ""
		        + "import javax.servlet.http.HttpSession;" + "\r\n" + ""
		        + "import org.springframework.web.bind.annotation.RequestMapping;" + "\r\n" + ""
				+ "import " + pkg + ".service." + b + "Service;" + "\r\n" 
		        + "import " + pkg + ".domain." + b + ";" + "\r\n" + "\r\n" 
				+"@Controller"+ "\r\n" 
		        +"@RequestMapping(\"/"+s+"\")"+"\r\n"
		        + "public class " + b+ "Controller" + "\r\n"
				+"{" + "\r\n" 
		        +"	@Resource(name=\""+s+"Service\")"+"\r\n"
		        +"	private "+b+"Service "+s+"Service;"+"\r\n"
		        +"\r\n"
				+"}"
		        );
				
		// 4.关闭流
		bw.flush();
		bw.close();
	}

	// 6.Ebo
	private void generatorService() throws IOException
	{
		// 1.创建文件
		File f = new File("src/" + rootDir + "/service/" + b + "Service.java");

		if (f.exists())
		{
			System.out.println(b+"Service already existed");
			return;
		}

		f.createNewFile();
		// 2.绑定IO流
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		// 3.写内容
		bw.write("package " + pkg + ".service;" + "\r\n" + "" + "\r\n" 
		
				+ "import " + pkg + ".domain." + b + ";" + "\r\n" 
				
				+"public interface "+b+"Service" +"\r\n"
				+"{" + "\r\n" + "\r\n"
				+ "}");
		// 4.关闭流
		bw.flush();
		bw.close();
	}

	// 5.Ebi
	private void generatorServiceImpl() throws IOException
	{
		// 1.创建文件
		File f = new File("src/" + rootDir + "/service/impl/" + b + "ServiceImpl.java");

		if (f.exists())
		{
			System.out.println(b+"ServiceImpl already existed");
			return;
		}

		f.createNewFile();
		// 2.绑定IO流
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		// 3.写内容
		bw.write("package " + pkg + ".service.impl;" + "\r\n" + "\r\n" 
		        + "import org.springframework.transaction.annotation.Transactional;" + "\r\n" 
		        + "import javax.annotation.Resource;" + "\r\n" 
				+ "import " + pkg + ".domain." + b + ";" + "\r\n" 
				+ "import " + pkg + ".dao." + b + "Dao;" + "\r\n" 
				+ "import " + pkg + ".service." + b + "Service;" + "\r\n" 
				+ "import org.springframework.stereotype.Service;" + "\r\n" + "\r\n"
				+"@Service(value=\""+s+"Service\")"+"\r\n"
		        + "@Transactional" + "\r\n" 
		        + "public class " + b + "ServiceImpl implements " +b+"Service" + "\r\n"+ "{" + "\r\n" + "\r\n" 
		        
		        +"	@Resource(name=\""+s+"Dao\")"+"\r\n"
		        +"	private "+b+"Dao " +s+"Dao;"+ "\r\n"+"\r\n"
		        + "}");

		// 4.关闭流
		bw.flush();
		bw.close();
	}

	// 4.Impl
	private void generatorDaoImpl() throws IOException
	{
		// 1.创建文件
		File f = new File("src/" + rootDir + "/dao/impl/" + b + "DaoImpl.java");

		if (f.exists())
		{
			System.out.println(b+"DaoImpl already existed");
			return;
		}

		f.createNewFile();
		// 2.绑定IO流
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		// 3.写内容
		bw.write("package " + pkg + ".dao.impl;" + "\r\n" + "\r\n" 
		+ "import org.hibernate.criterion.DetachedCriteria;" + "\r\n" 
				+ "import org.springframework.stereotype.Repository;" + "\r\n" + "\r\n"
		        + "import " + pkg + ".dao." + b + "Dao;" + "\r\n" 
				+ "import " + pkg + ".domain." + b + ";" + "\r\n" 
				+ "import com.hkbu.base.BaseDao;" + "\r\n" 
				+ "import com.hkbu.base.BaseDaoImpl;" + "\r\n" 
		        + "import com.hkbu.base.BaseQueryModel;" + "\r\n" + "\r\n"
				+"@Repository(value=\" "+s+"Dao\")"+ "\r\n"
				+ "public class " + b + "DaoImpl extends BaseDaoImpl<" + b + "> implements " + b + "Dao"+"\r\n"
				+"{" + "\r\n" + "\r\n" 
				+ "	public void doQbc(DetachedCriteria dc,BaseQueryModel qm)"+"\r\n"
				+"	{" + "\r\n" 
						
				+ "		// TODO 添加自定义查询条件" + "\r\n" + "	}" + "\r\n" + "\r\n" + "}");

		// 4.关闭流
		bw.flush();
		bw.close();
	}

	// 3.Dao
	private void generatorDao() throws IOException
	{
		// 1.创建文件
		File f = new File("src/" + rootDir + "/dao/" + b + "Dao.java");

		if (f.exists())
		{
			System.out.println(b+"Dao already existed");
			return;
		}

		f.createNewFile();
		// 2.绑定IO流
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		// 3.写内容
		bw.write("package " + pkg + ".dao;" + "\r\n" + "\r\n" 
		        + "import " + pkg+".domain."  + b +";" + "\r\n" 
		        + "import com.hkbu.base.BaseDao;" + "\r\n" + "\r\n" 
		        + "public interface " + b + "Dao extends BaseDao<" + b + ">"+"\r\n"
		        +"{" + "\r\n" + "\r\n" + "}");
		bw.newLine();

		// 4.关闭流
		bw.flush();
		bw.close();
	}

	// 1.QueryModel
	private void generatorQueryModel() throws IOException
	{

	}

	// 0.生成所有要使用的目录
	private void generatorDirectory()
	{

	}

	// -1.数据初始化
	private void dataInit()
	{

		String className = clazz.getSimpleName();
		b = className.substring(0); // Dep
		l = b.substring(0, 1).toLowerCase(); // d
		s = l + b.substring(1); // dep
		pkg = "com.hkbu";
		rootDir = "com/hkbu";
		
		System.out.println(pkg);
	}

	public static void main(String[] args) throws IOException
	{
		 new Generator(Supplier.class);
		 new Generator(Components.class);
		 new Generator(ComponentsType.class);
		 new Generator(Dep.class);
		 new Generator(Emp.class);
		 new Generator(EmpRole.class);
		 new Generator(POrder.class);
		 new Generator(POrderdetail.class);
		 new Generator(SOrder.class);
		 new Generator(SOrderdetail.class);
		 new Generator(Transaction.class);
	}

}
