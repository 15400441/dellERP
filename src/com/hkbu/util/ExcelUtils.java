package com.hkbu.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hkbu.domain.Transaction;

public class ExcelUtils
{
	public static byte[] generateExcel(List<Transaction> list) throws Exception {
        ByteArrayOutputStream out = null;
        try {
        	XSSFWorkbook book=new XSSFWorkbook();
        	

    		XSSFSheet sheet = book.createSheet("transactions of this month");
    		sheet.setColumnWidth(0, 18*256);
    		sheet.setColumnWidth(1, 18*256);
    		sheet.setColumnWidth(2, 18*256);
    		sheet.setColumnWidth(3, 18*256);
    		sheet.setColumnWidth(4, 18*256);
    		int countRowNum = 0;
    		
    		//add header
    		XSSFRow rowHeader = sheet.createRow(countRowNum++);
    		XSSFRow spaceRow = sheet.createRow(countRowNum++);
    		XSSFRow spaceRow1 = sheet.createRow(countRowNum++);
    		XSSFCell cellHeader=rowHeader.createCell(0);
    		cellHeader.setCellValue("                    Transactions from "+MyUtils.getStringDate().get("startDate")
    				+" to "+ MyUtils.getStringDate().get("endDate"));
    		
    		sheet.addMergedRegion(new CellRangeAddress(0, countRowNum-1, 0, 4));
    		//add field
   
    		 
    		XSSFRow fieldRow = sheet.createRow(countRowNum++);
    		int cellNum=0;
    		XSSFCell tranId = fieldRow.createCell(cellNum++);
    		tranId.setCellValue("Transaction ID");
    		XSSFCell TranType = fieldRow.createCell(cellNum++);
    		TranType.setCellValue("Transaction type");
    		XSSFCell income = fieldRow.createCell(cellNum++);
    		income.setCellValue("Income");
    		XSSFCell expense = fieldRow.createCell(cellNum++);
    		expense.setCellValue("Expense");
    		XSSFCell date = fieldRow.createCell(cellNum++);
    		date.setCellValue("Date");
    		
    		//add value
    		float totalIncome=0;
    		float totalExpense=0;
    		for (Transaction t : list)
			{
    			if (t.getMoneyIn()==null)
    				t.setMoneyIn((float) 0);
    			if (t.getMoneyOut()==null)
    				t.setMoneyOut((float) 0);
    			
    			int num=0;
    			XSSFRow row = sheet.createRow(countRowNum++);
    			XSSFCell id=row.createCell(num++);
    			XSSFCell type=row.createCell(num++);
    			XSSFCell in=row.createCell(num++);
    			XSSFCell ex=row.createCell(num++);
    			XSSFCell d=row.createCell(num++);
    			id.setCellValue(t.getUuid());
    			type.setCellValue(t.getType());
    			in.setCellValue(t.getMoneyIn());
    			ex.setCellValue(t.getMoneyOut());
    			d.setCellValue(MyUtils.dateToString(t.getDate()));
    			
    			if(t.getMoneyIn()!=null)
    				totalIncome=totalIncome+t.getMoneyIn();
    			if(t.getMoneyOut()!=null)
    				totalExpense=totalExpense+t.getMoneyOut();
 		
			}
            
    		//footer
    		XSSFRow footer = sheet.createRow(countRowNum++);
    		int n=0;
    		XSSFCell footerCell = footer.createCell(n++);
    		footerCell.setCellValue("Total transaction income / Total transaction expense:"
    		+totalIncome+" / "+totalExpense);
            
    		sheet.addMergedRegion(new CellRangeAddress(countRowNum, countRowNum, 0, 4));
 
            
            out = new ByteArrayOutputStream();
            XSSFWorkbook hssWb =book;
            hssWb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return out.toByteArray();
    }

}
