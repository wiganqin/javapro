/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author 45441
 */
class MyThread implements Runnable{
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run(){
        for(int x = 0; x<5;x++){
            System.out.println(this.title + "运行,x="+x);
           try{
            Thread.sleep(1000);
           }catch(Exception e){
            e.printStackTrace();
           }
                   }
    }
}
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MyThread mt1 = new MyThread("线程A");
       MyThread mt2 = new MyThread("线程B");
       MyThread mt3 = new MyThread("线程C");
       Thread t1 = new Thread(mt1);
       t1.start();

       new Thread(mt2).start();
       new Thread(mt3).start();
     
        
    }
   
}
