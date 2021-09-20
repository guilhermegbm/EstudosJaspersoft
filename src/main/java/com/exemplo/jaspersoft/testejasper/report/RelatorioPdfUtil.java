package com.exemplo.jaspersoft.testejasper.report;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioPdfUtil {

	public static void printReportWithEmptyDataSource(String urlArquivoDestino, Map<String, Object> parameters, String urlToReport) throws Exception {

		try {
			InputStream jasperStream = RelatorioPdfUtil.class.getResourceAsStream(urlToReport);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			JasperPrint jp = null;

			JRDataSource emptyConnection = new JREmptyDataSource();
			jp = JasperFillManager.fillReport(jasperReport, parameters, emptyConnection);

			//Se quiser o vetor de bytes, basta retornar o byte[] da linha abaixo:
			//pdf = JasperExportManager.exportReportToPdf(jp);
			JasperExportManager.exportReportToPdfFile(jp, urlArquivoDestino);
		} catch (Exception e) {
			System.out.println("Erro ao criar report: ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	public static void printDecompiledReportWithEmptyDataSource (String urlArquivoDestino, Map<String, Object> parameters, String fullUrlToReport) throws Exception {

		try {
			File file = new File (fullUrlToReport); 
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath()); 
			JasperPrint jp = null;

			JRDataSource emptyConnection = new JREmptyDataSource();
			jp = JasperFillManager.fillReport(jasperReport, parameters, emptyConnection);

			//Se quiser o vetor de bytes, basta retornar o byte[] da linha abaixo:
			//pdf = JasperExportManager.exportReportToPdf(jp);
			JasperExportManager.exportReportToPdfFile(jp, urlArquivoDestino);
		} catch (Exception e) {
			System.out.println("Erro ao criar report: ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	//NOTA: Adapters internos que são configurados no Jaspersoft Studio se comportam como uma java.sql.Connection,
	//ou seja, para Reports que tenham tenham configurado um Adapter interno, será necessário passar uma Connection 
	//para esse método para que eles possam ser gerados normalmente  
	public static void printReportWithCustomConnection(String urlArquivoDestino, Map<String, Object> parameters, String urlToReport, Connection con) throws Exception {

		try {
			InputStream jasperStream = RelatorioPdfUtil.class.getResourceAsStream(urlToReport);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			JasperPrint jp = null;

			if (con == null) {
				throw new NullPointerException("Connection está nula");
			}

			jp = JasperFillManager.fillReport(jasperReport, parameters, con);

			JasperExportManager.exportReportToPdfFile(jp, urlArquivoDestino);
		} catch (Exception e) {
			System.out.println("Erro ao criar report: ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public static void printDecompiledReportWithCustomConnection (String urlArquivoDestino, Map<String, Object> parameters, String fullUrlToReport, Connection con) throws Exception {

		try {
			File file = new File (fullUrlToReport); 
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath()); 
			JasperPrint jp = null;

			if (con == null) {
				throw new NullPointerException("Connection está nula");
			}

			jp = JasperFillManager.fillReport(jasperReport, parameters, con);

			JasperExportManager.exportReportToPdfFile(jp, urlArquivoDestino);
		} catch (Exception e) {
			System.out.println("Erro ao criar report: ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	

	@SuppressWarnings("rawtypes")
	public static void printReportWithCustomCollectionDataSource(String urlArquivoDestino, Map<String, Object> parameters, String urlToReport, Collection collection) throws Exception {

		try {
			InputStream jasperStream = RelatorioPdfUtil.class.getResourceAsStream(urlToReport);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			JasperPrint jp = null;

			if (collection == null) {
				throw new NullPointerException("Collection está nula");
			}

			JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(collection);

			jp = JasperFillManager.fillReport(jasperReport, parameters, collectionDataSource);

			JasperExportManager.exportReportToPdfFile(jp, urlArquivoDestino);
		} catch (Exception e) {
			System.out.println("Erro ao criar report: ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
