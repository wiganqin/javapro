/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.mldn.lxh.vo;

/**
 *
 * @author 45441
 */
import java.util.Date;
public class Emp {
    
    private int empno;
    private String ename;
    private float sal;
     private String job;
     private Date hiredate;

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
       /**
     * Get the value of sal
     *
     * @return the value of sal
     */
    public float getSal() {
        return sal;
    }

    /**
     * Set the value of sal
     *
     * @param sal new value of sal
     */
    public void setSal(float sal) {
        this.sal = sal;
    }


   

    /**
     * Get the value of job
     *
     * @return the value of job
     */
    public String getJob() {
        return job;
    }

    /**
     * Set the value of job
     *
     * @param job new value of job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * Get the value of ename
     *
     * @return the value of ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * Set the value of ename
     *
     * @param ename new value of ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }


    /**
     * Get the value of empno
     *
     * @return the value of empno
     */
    public int getEmpno() {
        return empno;
    }

    /**
     * Set the value of empno
     *
     * @param empno new value of empno
     */
    public void setEmpno(int empno) {
        this.empno = empno;
    }

}
