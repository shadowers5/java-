package ExamSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/*
考试机，其中存储着题库，为了防止题库中的题重复，选用set集合存储,记得Question类重写hashCode()和equals()方法
 */
public class ExamMachine {
    //记录学生账号和密码
    private HashMap<String,String> userBank=new HashMap<String,String>();
    {
        userBank.put("张三","111");
        userBank.put("李四","222");
        userBank.put("王五","333");
    }
    private HashMap<String,String> userteacherbank=new HashMap<String,String>();
    {
    userteacherbank.put("ng","niegang");
    userteacherbank.put("gxq","gaoxiaoqing");
    }
   
    //登录方法
    public boolean login(String userName,String passWord){
        String realPassWord=userBank.get(userName);
        if(realPassWord!=null && realPassWord.equals(passWord))
            return true;
        return false;
    }
    public boolean login2(String userName,String passWord){
        String realPassWord=userteacherbank.get(userName);
        if(realPassWord!=null && realPassWord.equals(passWord))
            return true;
        return false;
    }

    //用Set集合作为题库
    public HashSet<Question> questionBank=new HashSet<Question>();
    //将题目加入题库
    {
        questionBank.add(new Question("下面哪个是合法的标识符？\n\tA.#_pound\n\tB._underscore\n\tC.5interstate\n\tD.class","B"));
        questionBank.add(new Question("下面哪个单词是java语言的关键字?\n\tA.sizeof\n\tB.abstract\n\tC.null\n\tD.String","B"));
        questionBank.add(new Question("Java中main()函数的返回值是什么?\n\tA.String\n\tB.int\n\tC.char\n\tD.void","D"));
        questionBank.add(new Question("下面哪个是main()函数的合法参数?\n\tA.char args[]\n\tB.char args[][]\n\tC.String args[]\n\tD.String args","C"));
        questionBank.add(new Question("以下哪个方法用于定义线程的执行体？\n\tA.start()\n\tB.init()\n\tC.run()\n\tD.main()","C"));
        questionBank.add(new Question("以下哪个约束符可用于定义成员常量？\n\tA.static\n\tB.final\n\tC.abstract \n\tD.No modifier can be used","B"));
        questionBank.add(new Question("提供Java存取数据库能力的包是？\n\tA.java.sql\n\tB.java.awt\n\tC.java.lang\n\tD.java.swing","A"));
        questionBank.add(new Question("对象的特征在类中表示为变量，称为类的?\n\tA.对象\n\tB.属性\n\tC.方法\n\tD.数据类型","B"));
        questionBank.add(new Question("下面哪个不能让线程停止执行？\n\tA.sleep();\n\tB.stop();\n\tC.wait();\n\tD.notify();","D"));
        questionBank.add(new Question("下面哪个不是String类提供的合法的方法？\n\tA.equals(String)\n\tB.trim()\n\tC.append()\n\tD.indexOf()","C"));
    }
    //随机生成试卷---ArrayList存储
    public ArrayList<Question> getPaper(int questionNum){
        //定义一个set来存储试卷中的题目，防止题目重复
        HashSet<Question> paper=new HashSet<Question>();
        //从题库中随机取题目作为试卷，为了让题库有序，先将题库放进一个List集合，通过list的有序性取题目
        ArrayList<Question> questionBank=new ArrayList<Question>(this.questionBank);
        //随机生成数字，用来取题库对应中的题目
        while(paper.size()<questionNum){
            int index=new Random().nextInt(this.questionBank.size());
            paper.add(questionBank.get(index));
        }
        return new ArrayList<Question>(paper);
    }

}
