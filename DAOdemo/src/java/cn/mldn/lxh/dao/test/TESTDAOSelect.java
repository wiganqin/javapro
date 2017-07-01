/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.mldn.lxh.dao.test;

/**
 *
 * @author 45441
 */
import java.util.* ;
import cn.mldn.lxh.factory.DAOFactory ;
import cn.mldn.lxh.vo.* ;
public class TESTDAOSelect{
	public static void main(String args[]) throws Exception{
		List<Emp> all = DAOFactory.getIEmpDAOInstance().findAll("") ;
		Iterator<Emp> iter = all.iterator() ;
		while(iter.hasNext()){
			Emp emp = iter.next() ;
			System.out.println(emp.getEmpno() + "、" + emp.getEname() + " --> " + emp.getJob()) ;
		}
	}
}
