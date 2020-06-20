package ExamSystem;

public class Question {
    private String title;//���
    private String answer;//��ȷ��

    public Question(String title,String answer){
        this.title=title;
        this.answer=answer;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAnswer(){
        return this.answer;
    }

    //Ҫ��дequals�����Լ�hashCode������������set�����б�֤��Ŀ���ظ�
    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj instanceof Question){
            Question anotherQuestion=(Question)obj;
            //�Ƚ�����Ƿ���ͬ
            if(this.getTitle().equals(anotherQuestion.getTitle()))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.getTitle().hashCode();
    }
}
