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
    //学生考试的方法,需要试卷，做完后返回答案
    public String[] exam(ArrayList<Question> paper){
        Scanner input=new Scanner(System.in);
        String[] answers=new String[paper.size()];
        for(int i=0;i<paper.size();i++){
            Question question=paper.get(i);
            System.out.println((i+1)+"."+question.getTitle());
            System.out.println("请输入你的答案：");
            answers[i]=input.nextLine();
        }
        return answers;
    }
}
