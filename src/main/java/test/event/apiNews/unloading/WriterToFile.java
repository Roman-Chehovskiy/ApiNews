package test.event.apiNews.unloading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.event.apiNews.dto.DtoWriter;
import test.event.apiNews.entity.News;
import test.event.apiNews.entity.Sources;
import test.event.apiNews.services.impl.NewsServicesImp;
import test.event.apiNews.services.impl.SourcesServiceImpl;

import java.io.*;
import java.util.List;

// класс для записи данных в csv-файл
@Service
public class WriterToFile {


    SourcesServiceImpl sourcesServiceImpl;
    NewsServicesImp newsServicesImp;

    @Autowired
    public WriterToFile(SourcesServiceImpl sourcesServiceImpl, NewsServicesImp newsServicesImp) {
        this.sourcesServiceImpl = sourcesServiceImpl;
        this.newsServicesImp = newsServicesImp;
    }

    public WriterToFile() {
    }

    //получаем количество новостей по рессурсу и записываем в DtoWriter
    private DtoWriter getSourceAndCount(String source) {
        List<News> newsAllList = newsServicesImp.getNewsBySource(source);
        DtoWriter dtoWriter = new DtoWriter();
        dtoWriter.setSource(source);
        dtoWriter.setCountSource(newsAllList.size());
        return dtoWriter;
    }

    //запись объекта dtoWriter в csv-файл
    private void writeDtoToCsv(DtoWriter dtoWriter) {
        try {
            File fileScv = new File("src/main/resources/csv/" + dtoWriter.getSource() + ".csv");
            FileWriter fileWriter = new FileWriter(fileScv, true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.write(dtoWriter.toString());
            writer.write("\n");
            writer.flush();
            writer.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        List<Sources> listSources = sourcesServiceImpl.getSources();
        for (Sources source : listSources) {
            DtoWriter dtoWriter = getSourceAndCount(source.getSource());
            writeDtoToCsv(dtoWriter);
        }
    }
}
