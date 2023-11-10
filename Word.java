package Base;
public class Word {
     private String word_target;
     private String word_type;
     private String word_explain;
     private String word_example;

     public Word() {
         this.word_target = "";
         this.word_type = "";
         this.word_explain = "";
         this.word_example = "";
     }

     public Word(String word_target, String word_type, String word_explain, String word_example) {
         this.word_target = word_target;
         this.word_type = word_type;
         this.word_explain = word_explain;
         this.word_example = word_example;
     }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_type(String word_type) {
        this.word_type = word_type;
    }

    public String getWord_type() {
        return word_type;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_example() {
        return word_example;
    }

    public void setWord_example(String word_example) {
        this.word_example = word_example;
    }

    public String getWord_explain() {
        return word_explain;
    }
}
