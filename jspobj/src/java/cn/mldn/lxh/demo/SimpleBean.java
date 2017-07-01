/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.mldn.lxh.demo;

/**
 *
 * @author 45441
 */
public class SimpleBean {
        private String name ;
        private int age ;
        /*
        public SimpleBean(){
                System.out.println("============ 一个新的实例化对象产生 ===========") ;
        }
        */
        public void setName(String name){
                this.name = name ;
        }
        public void setAge(int age){
                this.age = age ;
        }
        public String getName(){
                return this.name ;
        }
        public int getAge(){
                return this.age ;
        }
}
