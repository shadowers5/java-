package ExamSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Student {
    private String userName;
    private String passWord;
    private int fenshu;

    public String getUserName() {
        return userName;
    }
    public String getPassWord(){
        return passWord;
    }

    public Student(String userName,String passWord){
        this.userName=userName;
        this.passWord=passWord;
       
    }
    //ѧ�����Եķ���,��Ҫ�Ծ�����󷵻ش�
    public String[] exam(ArrayList<Question> paper){
        Scanner input=new Scanner(System.in);
        String[] answers=new String[paper.size()];
        for(int i=0;i<paper.size();i++){
            Question question=paper.get(i);
            System.out.println((i+1)+"."+question.getTitle());
            System.out.println("��������Ĵ𰸣�");
            answers[i]=input.nextLine();
        }
        return answers;
    }
}
