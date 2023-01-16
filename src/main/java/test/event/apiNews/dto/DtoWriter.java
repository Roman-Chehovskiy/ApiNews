package test.event.apiNews.dto;

//объект для записи в csv-файл
public class DtoWriter {

    //название источника новости
    private String source;
    //количество новостей по источнику
    private int countSource;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getCountSource() {
        return countSource;
    }

    public void setCountSource(int countSource) {
        this.countSource = countSource;
    }

    @Override
    public String toString() {
        return source + " , " + countSource;
    }
}
