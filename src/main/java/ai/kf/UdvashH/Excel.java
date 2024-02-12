package ai.kf.UdvashH;


import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {
    public static void createExcelFile(ArrayList<Video> videos, String excelFilePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Dudvash");

            // Create headers for the columns
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Subject");
            headerRow.createCell(1).setCellValue("Title");
            headerRow.createCell(2).setCellValue("Lecture");
            headerRow.createCell(3).setCellValue("URL");

            // Populate the data in the Excel sheet from the ArrayList
            for (int i = 0; i < videos.size(); i++) {
                Video video = videos.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(1).setCellValue(video.getTitle());
                row.createCell(2).setCellValue(video.getLecture());
                row.createCell(0).setCellValue(video.getSubject());
                CreationHelper createHelper = workbook.getCreationHelper();
                Hyperlink link = createHelper.createHyperlink(HyperlinkType.URL);
                link.setAddress(video.getUrl());
                link.setLabel("Watch");
                XSSFCell cell = (XSSFCell) row.createCell(3);
                cell.setHyperlink(link);
                cell.setCellValue("Watch");
            }

            // Save the Excel file
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Excel file created successfully at: " + excelFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
