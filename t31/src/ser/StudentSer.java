package ser;

import impl.StudentImpl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Student;

/*
 * 在JSP中,Ser它的作用是控制层 也就是获取前台的数据,并且把数据提交给业务逻辑层
 * 
 * Ser起着桥梁的作用  它符合MVC设计模式
 * 
 * V: view 视图 所有的JSP页面 ：功能：显示数据 获取数据
 * 
 * C: control: 控制层  功能：获取视图层的数据,并且调用业务逻辑类
 * 
 * M: Model: 负责数据录入 和业务逻辑的实现
 * 
 * */

public class StudentSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private String sname=null;
	
	public StudentSer() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	
	/* Ser 销毁的时候调用此方法 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentImpl studentImpl=new StudentImpl();
		String status=request.getParameter("status");
		if(status.equals("queryStudent")){
			sname=request.getParameter("sname");
			ArrayList<Student> students=studentImpl.queryStudent(sname);
			//如果把数据从Ser传递到视图页面中
			request.setAttribute("students", students);
			//页面之间跳转 ser-->jsp :此跳转是内部跳转不能跳转到工程外的页面
			RequestDispatcher dispatcher=request.getRequestDispatcher("/queryStudent.jsp");
			dispatcher.forward(request, response);
		}else if(status.equals("saveStudent")){
			Student student=new Student();
			student.setSname(request.getParameter("sname"));
			student.setSaddress(request.getParameter("saddress"));
			String[] slikes=request.getParameterValues("slikes");
			student.setSlikes(studentImpl.joinString(slikes));
			studentImpl.saveStudent(student);
		}else if(status.equals("deleteStudent")){
			int sid=Integer.parseInt(request.getParameter("sid"));
			studentImpl.deleteStudent(sid);
			//由于数据库记录发生的改变,所以前台的页面要同步更新
			ArrayList<Student> students=studentImpl.queryStudent(sname);
			//如果把数据从Ser传递到视图页面中
			request.setAttribute("students", students);
			//页面之间跳转 ser-->jsp :此跳转是内部跳转不能跳转到工程外的页面
			RequestDispatcher dispatcher=request.getRequestDispatcher("/queryStudent.jsp");
			dispatcher.forward(request, response);
		}else if(status.equals("updateStudent")){
			Student student=new Student();
			student.setSid(Integer.parseInt(request.getParameter("sid")));
			student.setSname(request.getParameter("sname"));
			student.setSaddress(request.getParameter("saddress"));
			studentImpl.updateStudent(student);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	// 初始化的方法,会在构造方法之后调用
	public void init() throws ServletException {
		// Put your code here
	}

}
