package ExamSystem;

import java.util.ArrayList;

/*
**老师负责批改试卷
 */
public class Teacher {

    //老师批改试卷需要一张有考试答案的试卷，批改完给出分数
    public int checkPaper(ArrayList<Question> paper,String[] answers){
        System.out.println("改卷需要时间，请等待");
        int score=0;
        for(int i=0;i<paper.size();i++){
            Question question=paper.get(i);
            if(question.getAnswer().equalsIgnoreCase(answers[i]))//比较时忽略选项的大小写
                score+=100/paper.size();
        }
        return score;
    }
}
