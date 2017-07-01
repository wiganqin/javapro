/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.mldn.lxh.dao;
import java.util.List;
import cn.mldn.lxh.vo.Emp;
/**
 *
 * @author 45441
 */
public interface IEmpDAO {
    public boolean doCreate(Emp emp) throws Exception;
    public List<Emp> findAll(String keyWord) throws Exception;
    public Emp findById(int empno) throws Exception;
}
