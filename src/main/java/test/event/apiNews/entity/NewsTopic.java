package test.event.apiNews.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

//сущность для отоюражения новости по теме
@Entity
@Table(name = "news")
@SecondaryTable(name = "topics")
public class NewsTopic {
    private Long id;
    @Expose
    private String topic;
    @Expose
    private String item;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "topic", table = "topics")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(name = "item")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
