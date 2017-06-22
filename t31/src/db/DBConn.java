package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private String url; // �洢SQLSever����·��
    
	private String serverName; // �洢����������
    
	private String portNumber; // �洢�˿�����
    
	private String databaseName; // �洢���ݿ�����
    
	private String userName; // �洢�û�����
    
	private String password; // �洢����

	/* �����������ݿ���ز��� */
	
	public DBConn(){
		
		url = "jdbc:jtds:sqlserver://";
		
		serverName = "localhost";
		
        portNumber = "1433";
        
        databaseName = "master";
        
        userName = "sa";
        
        password = "sa";
		
	}
	
	/* ��ȡ�������ݿ�·�������� */
	
	private String getConnectionUrl() {
        
		return url + serverName + ":" + portNumber + ";databaseName=" + databaseName + ";";
		
    }
	
	/* ��ȡConncetion���󲢷��� */
	
	public Connection getConnection() {
		
		Connection con=null;
		
        try {
            	Class.forName("net.sourceforge.jtds.jdbc.Driver");     // ����Jdbc��������
            	
            	con = DriverManager.getConnection(getConnectionUrl(),userName,password);
            	
        } catch (Exception e) {
            
        	e.printStackTrace();
            
        	System.out.println("getConnection()�ڲ����ٴ���:"+ e.getMessage());
        }
        
        return con;
        
	}
}