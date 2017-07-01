/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.mldn.lxh.factory;

/**
 *
 * @author 45441
 */
import cn.mldn.lxh.dao.IEmpDAO ;
import cn.mldn.lxh.dao.proxy.EmpDAOProxy ;
public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance() throws Exception{
		return new EmpDAOProxy() ;
	}
}
