/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.register.demo;

/**
 *
 * @author 45441
 */
import java.util.HashMap;
import java.util.Map;
public class Register {
    private String name;
    private String age;
    private String email;
    private Map<String,String> errors = null;
    public Register(){
        this.name = "";
        this.email = "";
        this.age = "";
        this.errors = new HashMap<String,String>();
    }
    public boolean isValidate(){
        boolean flag = true;
        if(!this.name.matches("\\w{6,15}")){
            flag = false;
            this.name = "";
            errors.put("errname", "用户名是6-15位的字母或数字");
        }
       if(!this.email.matches("\\w+@\\w+\\.\\w+.?||w*")){
            flag = false;
            this.email = "";
            errors.put("erremail", "输入的email地址不合法");
        }
       if(!this.age.matches("\\d+")){
            flag = false;
            this.age = "";
            errors.put("errage", "年龄只能是数字");
        }
           return flag;
    }
    public String getErrorMsg(String key){
        String value = this.errors.get(key);
        return value == null ?"":value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
