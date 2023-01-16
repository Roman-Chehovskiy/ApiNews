package test.event.apiNews.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

//сущность для получения получения полной информации о новостях
//объеденяет данные из трех таблиц
@Entity
@Table(name = "news")
@SecondaryTables({
        @SecondaryTable(name = "topics"),
        @SecondaryTable(name = "sources")})
public class NewsAll {
    private Long id;
    @Expose
    private String source;
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

    @Column(name = "source", table = "sources")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "topic", table = "topics")
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(name = "item", table = "news")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
