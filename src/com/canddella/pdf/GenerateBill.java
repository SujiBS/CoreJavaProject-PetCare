package com.canddella.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Scanner;

import com.canddella.entity.Bill;
import com.canddella.service.BillServiceImpl;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class GenerateBill {

	public static void main(String[] args) {

		generateBillById();

	}

	public static void generateBillById() {

		String file_name = "C:\\Users\\sujibs\\Desktop\\ws_Canddella\\PCMS\\pdf\\demo.pdf";
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Bill Id to print: ");
			int billId = scanner.nextInt();

			BillServiceImpl billService = new BillServiceImpl();
			Bill bill = billService.generateBillById(billId);

			document.add(Image.getInstance("C:\\Users\\sujibs\\Desktop\\ws_Canddella\\PCMS\\pdf\\003.jpg"));

			Paragraph para = new Paragraph(
					"___________________________________" + "Bill" + "______________________________________");
			document.add(new Paragraph(""));
			Paragraph bill_id = new Paragraph("Bill ID : " + bill.getBillId());
			Paragraph cust_name = new Paragraph(
					"Customer Name : " + bill.getRegistration().getCustomer().getCustomerName());
			Paragraph amount = new Paragraph("Amount : " + bill.getAmount());
			Date date = new Date();
			Paragraph bill_date = new Paragraph("Date : " + date);

			document.add(para);
			document.add(bill_id);
			document.add(cust_name);
			document.add(amount);
			document.add(bill_date);

			document.close();

			System.out.println("Bill Generated Successfully.....");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
