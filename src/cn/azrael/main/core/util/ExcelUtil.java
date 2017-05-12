package cn.azrael.main.core.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletOutputStream;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.entity.PurchaseOrder;

public class ExcelUtil {
	/**
	 * 创建linen excel
	 * @param linen 洗涤单
	 * @param outputStream 浏览器输出流
	 */
	public static void exportLinenExcel(Linen linen,ServletOutputStream outputStream){
		
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//创建合并单元格
		CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);//起始行号，结束行号，起始列号，结束列号
		
		//头标题样式
		XSSFCellStyle style1 = createCellStyle(workbook, (short)16);
		//列标题样式
		XSSFCellStyle style2 = createCellStyle(workbook, (short)13);
		
		//创建工作表
		XSSFSheet sheet = workbook.createSheet("布草洗涤清单");
		//加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		//设置默认列宽
		sheet.setDefaultColumnWidth(20);
		
		//创建头标题行；并且设置头标题
		XSSFRow row1 = sheet.createRow(0);
		XSSFCell cell1 = row1.createCell(0);
		//加载单元格样式
		cell1.setCellStyle(style1);
		cell1.setCellValue("酒店布草洗涤清单");
		
		//创建列标题行；并且设置列标题
		XSSFRow row2 = sheet.createRow(1);
		String[] titles = {"布草名称","接收数量","送出数量","回洗数量","欠收数量"};
		for(int i = 0;i < titles.length;i++){
			XSSFCell cell2 = row2.createCell(i);
			//加载样式
			cell2.setCellStyle(style2);
			cell2.setCellValue(titles[i]);
		}
		//行号
		int i = 2;
		//操作单元格；将用洗涤清单写入excel
		if(linen!=null){
			Set<LinensInfo> linensInfos = linen.getLinensInfos();
			if(linensInfos!=null){
				for (LinensInfo linensInfo : linensInfos) {
					XSSFRow row = sheet.createRow(i);
					XSSFCell cell11 = row.createCell(0);
					cell11.setCellValue(linensInfo.getFacilitieId().getName());
					XSSFCell cell12 = row.createCell(1);
					cell12.setCellValue(linensInfo.getRecNum());
					XSSFCell cell13 = row.createCell(2);
					cell13.setCellValue(linensInfo.getSenNum());
					XSSFCell cell14 = row.createCell(3);
					cell14.setCellValue(linensInfo.getBackWashNum());
					XSSFCell cell15 = row.createCell(4);
					cell15.setCellValue(linensInfo.getOweNum());
					i++;
				}
			}
		}
		XSSFRow rowLast = sheet.createRow(i+1);
		XSSFCell celll1 = rowLast.createCell(0);
		celll1.setCellStyle(style2);
		celll1.setCellValue("负责人：");
		XSSFCell celll2 = rowLast.createCell(1);
		celll2.setCellValue(linen.getEmployeeId().getName());
		XSSFCell celll3 = rowLast.createCell(3);
		celll3.setCellStyle(style2);
		celll3.setCellValue("日期：");
		XSSFCell celll4 = rowLast.createCell(4);
		long time = linen.getDate().longValue();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		celll4.setCellValue(sdf.format(new Date(time*1000)));
		//输出
		try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建purchase excel
	 * @param purchaseOrder 采购单
	 * @param outputStream 浏览器输出流
	 */
	public static void exportPurchaseExcel(PurchaseOrder purchaseOrder,
			ServletOutputStream outputStream) {
		
		//创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//创建合并单元格
		CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 3);//起始行号，结束行号，起始列号，结束列号
		
		//头标题样式
		XSSFCellStyle style1 = createCellStyle(workbook, (short)16);
		//列标题样式
		XSSFCellStyle style2 = createCellStyle(workbook, (short)13);
		
		//创建工作表
		XSSFSheet sheet = workbook.createSheet("物品申购单");
		//加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		//设置默认列宽
		sheet.setDefaultColumnWidth(20);
		
		//创建头标题行；并且设置头标题
		XSSFRow row1 = sheet.createRow(0);
		XSSFCell cell1 = row1.createCell(0);
		//加载单元格样式
		cell1.setCellStyle(style1);
		cell1.setCellValue("酒店物品申购单");
		
		//创建列标题行；并且设置列标题
		XSSFRow row2 = sheet.createRow(2);
		String[] titles = {"申购物品","单价","数量","总价"};
		for(int i = 0;i < titles.length;i++){
			XSSFCell cell2 = row2.createCell(i);
			//加载样式
			cell2.setCellStyle(style2);
			cell2.setCellValue(titles[i]);
		}
		//行号
		int i = 3;
		double total = 0;
		//操作单元格；将用洗涤清单写入excel
		if(purchaseOrder!=null){
			Set<PurchaseInfo> purchaseInfos = purchaseOrder.getPurchaseInfos();
			if(purchaseInfos!=null){
				for (PurchaseInfo purchaseInfo : purchaseInfos) {
					XSSFRow row = sheet.createRow(i);
					XSSFCell cell11 = row.createCell(0);
					cell11.setCellValue(purchaseInfo.getFacilitieId().getName());
					XSSFCell cell12 = row.createCell(1);
					cell12.setCellValue(purchaseInfo.getPrice());
					XSSFCell cell13 = row.createCell(2);
					cell13.setCellValue(purchaseInfo.getPurchaseNum());
					XSSFCell cell14 = row.createCell(3);
					cell14.setCellValue(purchaseInfo.getPrice()*purchaseInfo.getPurchaseNum());
					total += purchaseInfo.getPrice()*purchaseInfo.getPurchaseNum();
					i++;
				}
			}
		}
		XSSFRow rowSecond = sheet.createRow(i+1);
		XSSFCell cells1 = rowSecond.createCell(2);
		cells1.setCellStyle(style2);
		cells1.setCellValue("总额：");
		XSSFCell cells2 = rowSecond.createCell(3);
		cells2.setCellValue(total);
		XSSFRow rowLast = sheet.createRow(1);
		XSSFCell celll1 = rowLast.createCell(0);
		celll1.setCellStyle(style2);
		celll1.setCellValue("申购人：");
		XSSFCell celll2 = rowLast.createCell(1);
		celll2.setCellValue(purchaseOrder.getEmployeeId().getName());
		XSSFCell celll3 = rowLast.createCell(2);
		celll3.setCellStyle(style2);
		celll3.setCellValue("申购日期：");
		XSSFCell celll4 = rowLast.createCell(3);
		long time = purchaseOrder.getDate().longValue();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		celll4.setCellValue(sdf.format(new Date(time*1000)));
		//输出
		try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建单元格样式
	 * @param workbook 工作簿
	 * @param fontSize 字体大小
	 * @return 单元格样式
	 */
	private static XSSFCellStyle createCellStyle(XSSFWorkbook workbook,short fontSize){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		//创建字体
		XSSFFont font = workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//加粗
		font.setFontHeightInPoints(fontSize);
		//加载字体
		style.setFont(font);
		return style;
	}
}
