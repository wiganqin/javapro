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
 * ��JSP��,Ser���������ǿ��Ʋ� Ҳ���ǻ�ȡǰ̨������,���Ұ������ύ��ҵ���߼���
 * 
 * Ser��������������  ������MVC���ģʽ
 * 
 * V: view ��ͼ ���е�JSPҳ�� �����ܣ���ʾ���� ��ȡ����
 * 
 * C: control: ���Ʋ�  ���ܣ���ȡ��ͼ�������,���ҵ���ҵ���߼���
 * 
 * M: Model: ��������¼�� ��ҵ���߼���ʵ��
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
	
	/* Ser ���ٵ�ʱ����ô˷��� */
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
			//��������ݴ�Ser���ݵ���ͼҳ����
			request.setAttribute("students", students);
			//ҳ��֮����ת ser-->jsp :����ת���ڲ���ת������ת���������ҳ��
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
			//�������ݿ��¼�����ĸı�,����ǰ̨��ҳ��Ҫͬ������
			ArrayList<Student> students=studentImpl.queryStudent(sname);
			//��������ݴ�Ser���ݵ���ͼҳ����
			request.setAttribute("students", students);
			//ҳ��֮����ת ser-->jsp :����ת���ڲ���ת������ת���������ҳ��
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
	// ��ʼ���ķ���,���ڹ��췽��֮�����
	public void init() throws ServletException {
		// Put your code here
	}

}
