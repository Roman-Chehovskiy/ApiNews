package test.event.apiNews.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.apiNews.entity.News;
import test.event.apiNews.repository.*;
import test.event.apiNews.services.NewsService;

import java.util.List;

@Service
public class NewsServicesImp implements NewsService {

    @Autowired
    NewsRepository newsRepository;
    @Autowired
    SourceRepository sourceRepository;

    //получаем все новости
    @Override
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    //получаем все новости по теме
    @Override
    public List<News> getNewsByTopic(String topic) {
       List<News> newsList = newsRepository.findNewsByTopic(topic);
        return newsList;
    }

    //получаем все новости по источнику
    @Override
    public List<News> getNewsBySource(String source) {
        return newsRepository.findNewsBySource(source);
    }
}
