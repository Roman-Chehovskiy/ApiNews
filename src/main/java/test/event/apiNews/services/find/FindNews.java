package test.event.apiNews.services.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.apiNews.entity.News;
import test.event.apiNews.entity.NewsAll;
import test.event.apiNews.entity.NewsTopic;
import test.event.apiNews.repository.*;

import java.util.List;

@Service
public class FindNews {

    @Autowired
    NewsRepository newsRepository;
    @Autowired
    AllNewsRepository allNewsRepository;
    @Autowired
    SourceRepository sourceRepository;
    @Autowired
    NewsTopicRepository newsTopicRepository;

    //получаем все новости
    public List<NewsAll> getAllNews() {
        return allNewsRepository.findAll();
    }

    //получаем все новости по теме
    public List<NewsTopic> getAllNewsByTopic(String topic) {
        return newsTopicRepository.findAllByTopic(topic);
    }

    //получаем все новости по источнику
    public List<NewsAll> getAllNewsBySource(String source) {
        return allNewsRepository.findAllBySource(source);
    }
}
