<%-- 
    Document   : input
    Created on : 2017-6-18, 17:08:58
    Author     : 45441
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
         <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <h1>Hello World!</h1>
        <%
            
////            String str =request.getParameter("info"); 
//            String str =  new String(request.getParameter("info").getBytes("iso-8859-1"), "utf-8"); 
//            out.println("<h2>"+str+"</h2>");
              %>
          <%!
              public static final String DBDRIVER = "com.mysql.jdbc.Driver";
              public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/mldn";
              public static final String DBUSER = "wigan";
              public static final String DBPASS = "123456";
          %>    
           <%
               Connection conn = null;
               PreparedStatement pstmt = null;
               ResultSet rs = null;
           %>   
           <%
               try{
               Class.forName(DBDRIVER);
               conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
               String sql = "select empno,ename,job,sal,hiredate from emp";
               pstmt = conn.prepareStatement(sql);;
               rs = pstmt.executeQuery();
               %>
               <table>
                   <tr>
                       <td>雇员编号</td>
                       <td>雇员姓名</td>
                       <td>雇员工作</td>
                       <td>雇员工资</td>
                       <td>雇员日期</td>
                   </tr>
              <%
                  while(rs.next()){
                      int empno = rs.getInt("empno");
                      String ename = rs.getString("ename");
                      String job = rs.getString("job");
                      float sal = rs.getFloat("sal");
                      java.util.Date date = rs.getDate("hiredate");
                  
              %>     
                   <tr>
                       <td><%=empno%></td>
                       <td><%=ename%></td>
                       <td><%=job%></td>
                       <td><%=sal%></td>
                       <td><%=date%></td>
                   </tr>
             <%
             }
             %>      
               </table>
               
               <%
               }catch(Exception e){
               System.out.println(e);
           }finally{
//               rs.close();
               pstmt.close();
               conn.close();
               }
           %>
    </body>
</html>
