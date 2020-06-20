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
    	int questionNum=5;//�Ծ����Ŀ����
    	int testtime=9;//����ʱ��
    	double[] a=new double[100];
    	int first=0;
    	HashMap newmap = new HashMap();
    	System.out.println("��ӭʹ�����߿���ϵͳ�����¼");
    	while(true)
    	{
        ExamMachine machine=new ExamMachine();//�������Ի�
        ArrayList paper=machine.getPaper(questionNum);//��������Ծ�
        Teacher teacher=new Teacher();
        Scanner input=new Scanner(System.in);
        System.out.println("����ʱ����"+testtime+"��");
        System.out.println("��ӭ���뿼��ϵͳ���������û�����");
        String userName=input.nextLine();
        System.out.println("���������룺");
        String passWord=input.nextLine();
        if(machine.login(userName,passWord)){
            Student student=new Student(userName,passWord);
            System.out.println("��¼�ɹ�!"+student.getUserName()+",�������Ͽ�ʼ������⣺");
            String[] answers=student.exam(paper);
            int score=teacher.checkPaper(paper,answers);
            System.out.println(student.getUserName()+"�ĳɼ�Ϊ��"+score);
            a[first]=score;
            first++;
            String n=score+"";
            System.out.println("�ַ�����"+n);
              newmap.put(userName,n);
        }else{
        	if(machine.login2(userName,passWord))
        	{
        		teachermanage teachermanage=new teachermanage(userName,passWord);
            System.out.println("��ϲ���¼���Թ���ϵͳ�ɹ�!��ӭ��,"+teachermanage.getUserName()+"��ʦ");
            System.out.println("1.������");
            System.out.println("2.���Թ���");
            System.out.println("3.�ɼ���ѯ");
            System.out.println("4.�ɼ�ͳ��");
            System.out.println("5.�˳�");
            System.out.println("��ѡ��1-5��");
            int k=input.nextInt();
            if(k==1)
            {
            	
            	 System.out.println("1.������Ŀ");
            	 System.out.println("2.ɾ����Ŀ");
            	 System.out.println("��ѡ��(1-2)");
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
            	System.out.println("���������ʱ�䣺");
            	int time=input.nextInt();
            	testtime=time;
            	System.out.println("�������Ծ���Ŀ������");
            	int num=input.nextInt();
            	questionNum=num;
            }
            if(k==3)
            {
            	System.out.println("������Ҫ��ѯѧ����id��");
            	String id=input.next();
            	
            	System.out.println("��ѧ���ĳɼ�Ϊ��"+newmap.get(id));
            }
            if(k==4)
            {
            	System.out.println("������������ֵ��"+MAX(a));
            	System.out.println("�����������Сֵ��"+MIN(a));
            	System.out.println("���������ƽ��ֵ��"+doubleArrAverage(a));
            }
            if(k==5)
            {
            	System.out.println("���˳�ϵͳ����ӭ�´�ʹ��");
            	break;
            }
        	}
        	else
            System.out.println("�û������������");
        }
    }
    }
}
