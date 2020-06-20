package ExamSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/*
���Ի������д洢����⣬Ϊ�˷�ֹ����е����ظ���ѡ��set���ϴ洢,�ǵ�Question����дhashCode()��equals()����
 */
public class ExamMachine {
    //��¼ѧ���˺ź�����
    private HashMap<String,String> userBank=new HashMap<String,String>();
    {
        userBank.put("����","111");
        userBank.put("����","222");
        userBank.put("����","333");
    }
    private HashMap<String,String> userteacherbank=new HashMap<String,String>();
    {
    userteacherbank.put("ng","niegang");
    userteacherbank.put("gxq","gaoxiaoqing");
    }
   
    //��¼����
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

    //��Set������Ϊ���
    public HashSet<Question> questionBank=new HashSet<Question>();
    //����Ŀ�������
    {
        questionBank.add(new Question("�����ĸ��ǺϷ��ı�ʶ����\n\tA.#_pound\n\tB._underscore\n\tC.5interstate\n\tD.class","B"));
        questionBank.add(new Question("�����ĸ�������java���ԵĹؼ���?\n\tA.sizeof\n\tB.abstract\n\tC.null\n\tD.String","B"));
        questionBank.add(new Question("Java��main()�����ķ���ֵ��ʲô?\n\tA.String\n\tB.int\n\tC.char\n\tD.void","D"));
        questionBank.add(new Question("�����ĸ���main()�����ĺϷ�����?\n\tA.char args[]\n\tB.char args[][]\n\tC.String args[]\n\tD.String args","C"));
        questionBank.add(new Question("�����ĸ��������ڶ����̵߳�ִ���壿\n\tA.start()\n\tB.init()\n\tC.run()\n\tD.main()","C"));
        questionBank.add(new Question("�����ĸ�Լ���������ڶ����Ա������\n\tA.static\n\tB.final\n\tC.abstract \n\tD.No modifier can be used","B"));
        questionBank.add(new Question("�ṩJava��ȡ���ݿ������İ��ǣ�\n\tA.java.sql\n\tB.java.awt\n\tC.java.lang\n\tD.java.swing","A"));
        questionBank.add(new Question("��������������б�ʾΪ��������Ϊ���?\n\tA.����\n\tB.����\n\tC.����\n\tD.��������","B"));
        questionBank.add(new Question("�����ĸ��������߳�ִֹͣ�У�\n\tA.sleep();\n\tB.stop();\n\tC.wait();\n\tD.notify();","D"));
        questionBank.add(new Question("�����ĸ�����String���ṩ�ĺϷ��ķ�����\n\tA.equals(String)\n\tB.trim()\n\tC.append()\n\tD.indexOf()","C"));
    }
    //��������Ծ�---ArrayList�洢
    public ArrayList<Question> getPaper(int questionNum){
        //����һ��set���洢�Ծ��е���Ŀ����ֹ��Ŀ�ظ�
        HashSet<Question> paper=new HashSet<Question>();
        //����������ȡ��Ŀ��Ϊ�Ծ�Ϊ������������Ƚ����Ž�һ��List���ϣ�ͨ��list��������ȡ��Ŀ
        ArrayList<Question> questionBank=new ArrayList<Question>(this.questionBank);
        //����������֣�����ȡ����Ӧ�е���Ŀ
        while(paper.size()<questionNum){
            int index=new Random().nextInt(this.questionBank.size());
            paper.add(questionBank.get(index));
        }
        return new ArrayList<Question>(paper);
    }

}
