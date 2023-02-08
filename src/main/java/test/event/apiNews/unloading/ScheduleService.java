package test.event.apiNews.unloading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduleService {

    @Autowired
    WriterToFile writer;

    //раз в минуту записываем данные в csv-файл
    @Scheduled(cron = "05 * * * * *")
    public void writeToCsv() {
        writer.write();
    }
}
