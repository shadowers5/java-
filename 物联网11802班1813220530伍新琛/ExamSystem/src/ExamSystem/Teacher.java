package ExamSystem;

import java.util.ArrayList;

/*
**��ʦ���������Ծ�
 */
public class Teacher {

    //��ʦ�����Ծ���Ҫһ���п��Դ𰸵��Ծ��������������
    public int checkPaper(ArrayList<Question> paper,String[] answers){
        System.out.println("�ľ���Ҫʱ�䣬��ȴ�");
        int score=0;
        for(int i=0;i<paper.size();i++){
            Question question=paper.get(i);
            if(question.getAnswer().equalsIgnoreCase(answers[i]))//�Ƚ�ʱ����ѡ��Ĵ�Сд
                score+=100/paper.size();
        }
        return score;
    }
}
