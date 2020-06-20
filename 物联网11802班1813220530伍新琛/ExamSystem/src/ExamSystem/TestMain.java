package ExamSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class TestMain {
	 public static double MAX(double[] arr) {
	        Arrays.sort(arr);
	        return arr[arr.length-1];
	    }
	
	 public static double MIN(double[] arr) {
	        Arrays.sort(arr);
	        return arr[0];
	    }
	 public static double doubleArrAverage(double[] arr) {
			double sum = 0;
			for(int i = 0;i < arr.length; i++) {
				sum += arr[i];
			}
			return sum / arr.length;
		}
	
    public static void main(String[] args){
    	int questionNum=5;//试卷的题目数量
    	int testtime=9;//考试时间
    	double[] a=new double[100];
    	int first=0;
    	HashMap newmap = new HashMap();
    	System.out.println("欢迎使用在线考试系统，请登录");
    	while(true)
    	{
        ExamMachine machine=new ExamMachine();//创建考试机
        ArrayList paper=machine.getPaper(questionNum);//随机生成试卷
        Teacher teacher=new Teacher();
        Scanner input=new Scanner(System.in);
        System.out.println("考试时间是"+testtime+"点");
        System.out.println("欢迎进入考试系统，请输入用户名：");
        String userName=input.nextLine();
        System.out.println("请输入密码：");
        String passWord=input.nextLine();
        if(machine.login(userName,passWord)){
            Student student=new Student(userName,passWord);
            System.out.println("登录成功!"+student.getUserName()+",考试马上开始，请答题：");
            String[] answers=student.exam(paper);
            int score=teacher.checkPaper(paper,answers);
            System.out.println(student.getUserName()+"的成绩为："+score);
            a[first]=score;
            first++;
            String n=score+"";
            System.out.println("字符串："+n);
              newmap.put(userName,n);
        }else{
        	if(machine.login2(userName,passWord))
        	{
        		teachermanage teachermanage=new teachermanage(userName,passWord);
            System.out.println("恭喜你登录考试管理系统成功!欢迎你,"+teachermanage.getUserName()+"老师");
            System.out.println("1.题库管理");
            System.out.println("2.考试管理");
            System.out.println("3.成绩查询");
            System.out.println("4.成绩统计");
            System.out.println("5.退出");
            System.out.println("请选择（1-5）");
            int k=input.nextInt();
            if(k==1)
            {
            	
            	 System.out.println("1.增加题目");
            	 System.out.println("2.删减题目");
            	 System.out.println("请选择(1-2)");
            	 int o=input.nextInt();
            	 if(o==1)
            	 {
            		 String str=input.next();
            		 String str2=input.next();
            		 machine.questionBank.add(new Question(str,str2));
            	 }
            		if(o==2)
            		{
            			String str=input.next();
               		 String str2=input.next();
            		machine.questionBank.remove(new Question(str,str2));
            		}
            	}
            	
       
            if(k==2)
            {
            	System.out.println("请输出考试时间：");
            	int time=input.nextInt();
            	testtime=time;
            	System.out.println("请设置试卷题目数量：");
            	int num=input.nextInt();
            	questionNum=num;
            }
            if(k==3)
            {
            	System.out.println("请输入要查询学生的id：");
            	String id=input.next();
            	
            	System.out.println("该学生的成绩为："+newmap.get(id));
            }
            if(k==4)
            {
            	System.out.println("请输出数组最大值："+MAX(a));
            	System.out.println("请输出数组最小值："+MIN(a));
            	System.out.println("请输出数组平均值："+doubleArrAverage(a));
            }
            if(k==5)
            {
            	System.out.println("已退出系统，欢迎下次使用");
            	break;
            }
        	}
        	else
            System.out.println("用户名或密码错误");
        }
    }
    }
}
