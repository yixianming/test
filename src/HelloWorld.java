import jdk.nashorn.internal.parser.JSONParser;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;


public class HelloWorld {


   public static void main(String[] args) {
       System.out.println(111111111);
      Student student = new Student("zhangsan",12);
       Class<? extends Student> aClass = student.getClass();
       Arrays.stream(aClass.getDeclaredFields()).forEach(
               x->{
                   if(x.getType()==Integer.class){
                       try {
                           System.out.println(student.getAge());
                           Method declaredMethod = aClass.getDeclaredMethod("set" + x.getName().substring(0, 1).toUpperCase(Locale.CHINA) + x.getName().substring(1),x.getType());
                           declaredMethod.invoke(student,new Object[]{100});
                           System.out.println(student.getAge());
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               }
       );
       /* String studentName = student.getName();
       Student student1 = new Student("lisi",4);
       Student student2 = new Student("wangwu",6);
       List<Student> list = new ArrayList<>();
       boolean a = list.add(student);
       list.add(student1);
       list.add(student2);*/
     //list.stream().sorted(Comparator.comparing(Student::getAge)).map(x -> x.getName()).forEach(x-> System.out.println(x));
       //System.out.println(collect.toString());
       //list.stream().filter(x -> x.getName().contains("a")).map(x -> new Student("",1)).collect(Collectors.toList());
//       System.out.println(a);
       /* List<String> list = new ArrayList<>();
        list.add("6");
        list.add("5");
        list.add("8");
        list.add("2");
        list.add("1");
        System.out.println(list.toString());
        String[] order = new String[]{"5","8","6","1","2"};
        List<String> orderList = new ArrayList<>();
        //Iterator<String> iterator = list.iterator();
        for (int i = 0; i < order.length; i++) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                if(order[i].equals(next)){
                    orderList.add(next);
                    iterator.remove();
                    break;
                }
            }

        }
        if(list.size()>0)
            orderList.addAll(list);
        System.out.println(orderList.toString());*/
    }
}
