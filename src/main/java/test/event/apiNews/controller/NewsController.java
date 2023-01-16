package test.event.apiNews.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.event.apiNews.dto.DtoReturnAnswer;
import test.event.apiNews.entity.NewsAll;
import test.event.apiNews.entity.NewsTopic;
import test.event.apiNews.services.find.FindNews;
import test.event.apiNews.services.find.FindSources;
import test.event.apiNews.services.find.FindTopics;

import java.util.List;

@RestController
@RequestMapping("/apiNews")
public class NewsController {

    private DtoReturnAnswer returnAnswer = new DtoReturnAnswer(400, "Invalid request");
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    @Autowired
    FindNews findNews;
    @Autowired
    FindSources findSources;
    @Autowired
    FindTopics findTopics;

    //получить новости
    @RequestMapping("/getNews")
    public String getNews(@RequestParam(required = false) String source, @RequestParam(required = false) String topic) {
        if (source == null && topic == null) {
            List<NewsAll> listNews = findNews.getAllNews();
            if (listNews.size() != 0) {
                return gson.toJson(listNews);
            } else {
                return gson.toJson(returnAnswer);
            }
        } else if (source != null && topic == null) {
            List<NewsAll> listNews = findNews.getAllNewsBySource(source);
            if (listNews.size() != 0) {
                return gson.toJson(listNews);
            } else {
                return gson.toJson(returnAnswer);
            }
        } else if (source == null && topic != null) {
            List<NewsTopic> listNews = findNews.getAllNewsByTopic(topic);
            if (listNews.size() != 0) {
                return gson.toJson(listNews);
            } else {
                return gson.toJson(returnAnswer);
            }
        } else {
            return gson.toJson(returnAnswer);
        }
    }

    //получить источники
    @RequestMapping("/getSources")
    public String getSources() {
        return gson.toJson(findSources.getSources());
    }

    //получить темы
    @RequestMapping("/getTopics")
    public String getTopics() {
        return gson.toJson(findTopics.getTopics());
    }

}
