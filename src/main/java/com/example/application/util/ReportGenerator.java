package com.example.application.util;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.domain.entity.User;
import com.example.domain.entity.User.User_;
import com.example.domain.shared.BaseEntity;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.component.PageXofYBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class ReportGenerator {
	public static final String PDF="PDF", XLS="XLS";
	
	
    public static void main(String[] args) {
		
 	   List<BaseEntity> users = new ArrayList<>();
 	   users.add(new User(1L, "Cristiano", "Arquiteto de Software"));
 	   users.add(new User(2L, "Felipe", "Desenvolvedor Java/PLSQL"));
 	   users.add(new User(3L, "Leticia", "Desenvolvedora Java/PHP"));
 	   users.add(new User(4L, "Tiago", "Desenvolvedora Java/PHP"));
 	   
 	   String path = buildDynamicPdf("report", "Relatório de Usuários", 
 			   			users, 
 			   			col("Código", User_.id, Long.class),
 			   			col("Usuário", User_.user, String.class),
 			   			col("Cargo", User_.role, String.class));
 	   
 	   System.out.println(path);
 	   
 	   Map<String, Object> maps = new HashMap<>();
 	   maps.put("cliente", "Teste Relatório");
 	   
 	   buildJasperPdf("c:/dev/badesc/workspace/demo/src/main/resources/jasperreports/Relatorio_de_Usuarios_A4.jrxml",
 			   "report_jrxml", maps, users);
	}
    
    
    public static String buildJasperPdf(String jrxml, String filename, Map<String, Object> parametros, List<BaseEntity> list) {

        try {
            JasperReport jasper = JasperCompileManager.compileReport(jrxml);
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros,  new JRBeanCollectionDataSource(list));
            File file = File.createTempFile(filename + "-", ".pdf");

            JRPdfExporter exporter = new JRPdfExporter();            
            exporter.setExporterInput(new SimpleExporterInput(print));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));            

//            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
//            exporter.setConfiguration(configuration);           
            
            exporter.exportReport();
            
            return file.getAbsolutePath();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }  
    
    
    
    public static String buildDynamicPdf(String filename, String title, List<BaseEntity> list, ColumnBuilder... cols) {    
	      StyleBuilder boldStyle         = stl.style().bold();
	      StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalTextAlignment (HorizontalTextAlignment.CENTER);
	      StyleBuilder titleStyle        = stl.style(boldCenteredStyle).setPadding(15).setFontSize(14);
	      StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle).setBorder(stl.pen1Point()).setBackgroundColor(Color.LIGHT_GRAY);
	      PageXofYBuilder paginator      = cmp.pageXofY().setStyle(boldCenteredStyle).setFormatExpression("{0} de {1}");
          File file = null;
	      
	      try {
	    	  file = File.createTempFile(filename + "-", ".xls");
	    	  
	    	  JasperReportBuilder report = report()
			           .setColumnTitleStyle(columnTitleStyle)
			           .highlightDetailEvenRows()
			           .columns(cols)
			           .title(cmp.text(title).setStyle(titleStyle))
			           .pageFooter(paginator)
			           .setDataSource(list);
	          report.show();
//	    	  JasperXlsExporterBuilder xlsExporter = 
//	    			  export.xlsExporter(file)
//		                 .setDetectCellType(true)
//		                 .setIgnorePageMargins(true)
//		                 .setWhitePageBackground(false)
//		                 .setRemoveEmptySpaceBetweenColumns(true);	    	  
//	    	  
//	           report.toXls(xlsExporter);


	      } catch (Exception e) {
	         e.printStackTrace();
	      }
          return file==null?null:file.getAbsolutePath();
	   }
    
    
       public static ColumnBuilder col(String title, String field, Class dataType){
 	      return col.column(title, field, dataType);
       }
    
}