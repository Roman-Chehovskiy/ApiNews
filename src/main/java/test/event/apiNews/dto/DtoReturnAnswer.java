package test.event.apiNews.dto;

import com.google.gson.annotations.Expose;

//объект для передачи ответа, если запрос не прошел
public class DtoReturnAnswer {
    @Expose
    private int key;
    @Expose
    private String answer;

    public DtoReturnAnswer(int key, String answer) {
        this.key = key;
        this.answer = answer;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
