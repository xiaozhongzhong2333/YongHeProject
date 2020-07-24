package com.zb.utils;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ExcelPOI {//此方法用于生成Excel

    public void exportExcel(String[] titles, ServletOutputStream out) throws IOException, SQLException {
        //创建一个excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //HSSFWorkbook中添加sheet
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet_01");
        //在sheet中添加表头
        HSSFRow hssfRow_00 = hssfSheet.createRow(0);
        //设置单元格样式  居中
        HSSFCellStyle hssfCellStyle = hssfWorkbook.createCellStyle();
        hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        //创建单元格
        HSSFCell hssfCell = null;
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow_00.createCell(i);
            hssfCell.setCellValue(titles[i]);
            hssfCell.setCellStyle(hssfCellStyle);
        }
        DoorDao doorDao = new DoorDao();
        List<Door> list = doorDao.findAll();
        for (int i = 0; i < list.size(); i++) {
            hssfRow_00 = hssfSheet.createRow(i + 1);
            Door door = list.get(i);
            Integer id = 0;
            if (door.getId() != 0) {
                id = door.getId();

            }
            hssfRow_00.createCell(0).setCellValue(id);

            String name="";
            if (door.getName() != null) {
                name = door.getName();
            }
            hssfRow_00.createCell(1).setCellValue(name);

            String tel="";
            if (door.getTel() != null) {
                tel = door.getTel();
            }
            hssfRow_00.createCell(2).setCellValue(tel);

            String addr="";
            if (door.getAddr() != null) {
                addr = door.getAddr();
            }
            hssfRow_00.createCell(3).setCellValue(addr);

            int  sale=0;
            if (door.getSale() != 0) {
                sale = door.getSale();
            }
            hssfRow_00.createCell(4).setCellValue(sale);
        }
        //将文件写出
        System.out.println("开始写出");
        hssfWorkbook.write(out);
        out.flush();
        out.close();
    }
}
