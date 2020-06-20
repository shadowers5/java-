package ExamSystem;

public class Question {
    private String title;//题干
    private String answer;//正确答案

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

    //要重写equals方法以及hashCode方法，才能在set集合中保证题目不重复
    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj instanceof Question){
            Question anotherQuestion=(Question)obj;
            //比较题干是否相同
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
