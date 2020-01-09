package com.dk.learndemo.Excel;

import org.apache.commons.collections4.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelTest {

    /**
     * list中的数据 转成excel
     * 在浏览器中返回
     * 用于controller
     * */
    public void downExcel(List<Map> listData, HttpServletResponse response) throws IOException {
        if(null == listData || listData.size() == 0){
            return;
        }
        HSSFWorkbook wb = new HSSFWorkbook();
        //只有一个sheet
        HSSFSheet sheet = wb.createSheet("1");
        //行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("列1");
        cell = row.createCell(1);
        cell.setCellValue("列2");
        cell = row.createCell(2);

        //====写数据，从标题的下一行开始====
        //MapUtils
        for (int i = 0; i < listData.size(); i++) {
            row = sheet.createRow(i+1);
            Map<String, String> data = listData.get(i);
            cell = row.createCell(0);
            cell.setCellValue(MapUtils.getString(data,"业务识别号"));
            cell = row.createCell(1);
            cell.setCellValue(MapUtils.getString(data, "业务类型"));
        }
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ new String("test.xls".getBytes(), "ISO8859-1"));
        wb.write(response.getOutputStream());
        response.flushBuffer();

    }

}
