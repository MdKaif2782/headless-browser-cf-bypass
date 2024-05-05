package ai.kf.scrapping.chiral.suicidenews.sources.prothomalo;

import ai.kf.scrapping.chiral.suicidenews.sources.prothomalo.model.News;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProthomAlo {
    private static final Logger log = LogManager.getLogger(ProthomAlo.class);

    public static void main(String[] args) throws IOException {
        int limit = 600;
        String url = "https://en.prothomalo.com/api/v1/advanced-search?section-id=16600%2C16725%2C16727%2C16728%2C17129%2C17134%2C17135%2C17136%2C17137%2C17139%2C35627&q=heat+stroke&offset=0&limit="+limit+"&fields=headline%2Csubheadline%2Cslug%2Curl%2Ctags%2Chero-image-s3-key%2Chero-image-caption%2Chero-image-metadata%2Clast-published-at%2Calternative%2Cauthors%2Cauthor-name%2Cauthor-id%2Csections%2Cstory-template%2Cmetadata%2Chero-image-attribution%2Caccess";
        String res = getJsonRes(url);
        Gson gson = new Gson();
        News news = gson.fromJson(res, News.class);

        ArrayList<News.Item> expected = new ArrayList<>();
        ArrayList<News.Item> items = (ArrayList<News.Item>) news.getItems();


        for (News.Item item : items) {
            ArrayList<News.Tag> tags= (ArrayList<News.Tag>) item.getTags();
            boolean containsHeat = false;
            boolean containsDeath = false;
            for (News.Tag tag : tags) {
                if (tag.getName().toLowerCase().contains("heat")) {
                    containsHeat = true;
                }
                if (tag.getName().toLowerCase().contains("death")) {
                    containsDeath = true;
                }
            }
            if (containsHeat) {
                expected.add(item);
            }
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("News");

        // Create header row
        Row headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("Title");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("URL");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("Date");

        // Fill data
        for (int i = 0; i < expected.size(); i++) {
            News.Item item = expected.get(i);
            Row row = sheet.createRow(i + 1); // +1 because header row is at 0

            Cell cell1 = row.createCell(0);
            cell1.setCellValue(item.getHeadline());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(item.geturl());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date(item.getLastPublishedAt())));
        }

        FileOutputStream fileOut = new FileOutputStream("prothomalo.xlsx");
        workbook.write(fileOut);


        int count = 0;
        for (News.Item item : expected) {
            count++;
            System.out.println(count+ " "+item.getHeadline());

        }
    }


    public static String getJsonRes(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}

