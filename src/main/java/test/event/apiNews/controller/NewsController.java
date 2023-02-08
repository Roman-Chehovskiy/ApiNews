package test.event.apiNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.event.apiNews.entity.News;
import test.event.apiNews.entity.Sources;
import test.event.apiNews.entity.Topic;
import test.event.apiNews.exeption_handling.NoSuchNewsException;
import test.event.apiNews.services.impl.NewsServicesImp;
import test.event.apiNews.services.impl.SourcesServiceImpl;
import test.event.apiNews.services.impl.TopicServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiNews")
public class NewsController {

    @Autowired
    NewsServicesImp newsServicesImp;
    @Autowired
    SourcesServiceImpl sourcesServiceImpl;
    @Autowired
    TopicServiceImpl topicServiceImpl;

    //получить новости
    @GetMapping("/News")
    public List<News> getNews(@RequestParam(required = false) String source, @RequestParam(required = false) String topic) {
        List<News> listNews = new ArrayList<>();
        News news = null;
        if (source == null && topic == null) {
            listNews = newsServicesImp.getNews();
        }
        if (source != null && topic == null) {
            listNews = newsServicesImp.getNewsBySource(source);
        }
        if (source == null && topic != null) {
           listNews = newsServicesImp.getNewsByTopic(topic);
        }

        if(listNews.size() == 0) {
            throw new NoSuchNewsException("No news found for your query");
        }
        return listNews;
    }


    //получить источники
    @GetMapping("/sources")
    public List<Sources> getSources() {
        return sourcesServiceImpl.getSources();
    }

    //получить темы
    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return topicServiceImpl.getTopics();
    }

}
