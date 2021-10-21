package com.exemplo.jaspersoft.testejasper.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Cartorio;
import com.exemplo.jaspersoft.testejasper.entity.Fechamento;
import com.exemplo.jaspersoft.testejasper.entity.Oficial;
import com.exemplo.jaspersoft.testejasper.service.RelatorioExtratoOnlineService;
import com.exemplo.jaspersoft.testejasper.vo.RelatorioExtratoOnlineVO;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class Teste9RelatorioExtratoOnlineReport {
	
//	@Autowired
//	private ExtratoMensalRepository extratoMensalRepository; 


	public void gerarRelatorioExtratoOnline(RelatorioExtratoOnlineVO valores)
			throws Exception {

		String destino = "C:\\Users\\marry\\Desktop\\reports_gerados\\Teste9.pdf";
		String origemPai = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste9_RelatorioExtratoOnline.jrxml";
		String origemSubReport1Oficiais = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste9_RelatorioExtratoOnlineSubReport1Oficiais.jrxml";
		String origemSubReport2Cartorios = "C:\\Users\\marry\\Documents\\apis\\testejasper\\src\\main\\resources\\relatorios\\Teste9_RelatorioExtratoOnlineSubReport2Cartorios.jrxml";
		
		
	
			
//		// Instancia o subReport como file
//		File fileSubReport1Oficiais = new File (origemSubReport1Oficiais); 
//		File fileSubReport2Cartorios = new File (origemSubReport2Cartorios); 
//		
//		JasperReport jasperSubReport1Oficiais = JasperCompileManager.compileReport(fileSubReport1Oficiais.getAbsolutePath()); 
//		JasperReport jasperSubReport2Cartorios = JasperCompileManager.compileReport(fileSubReport2Cartorios.getAbsolutePath()); 
//		
//		//Passa o subReport como parametro
//		parametros.put("SUB_REPORT_1_OFICIAIS", jasperSubReport1Oficiais);
//		parametros.put("SUB_REPORT_2_CARTORIOS", jasperSubReport2Cartorios);

		//Passa a List<E> como parametro do tipo JRBeanCollection
//		List<Oficial> CollectionOficiais = this.extratoOnlineService.listarOficiais();
//		List<Fechamento> CollectionCartorios = this.extratoOnlineService.listarCartorios();
//	
//		parametros.put("LISTA_OFICIAIS", new JRBeanCollectionDataSource(CollectionOficiais));
//		parametros.put("LISTA_CARTORIOS", new JRBeanCollectionDataSource(CollectionCartorios));
		
		RelatorioPdfUtil.printDecompiledReportWithCustomCollectionDataSource(destino, origemPai, criaPametros(valores), separarListaFechamento(valores) );
	}
	
	
	private List<Fechamento> separarListaFechamento (RelatorioExtratoOnlineVO vo){
		
		List<Fechamento> fechamentos = new ArrayList<Fechamento>(); 	
		
		for (Oficial ofic:vo.getValoresPorPessoaEMes().getOficiais()) {
			for (Fechamento fec: ofic.getFechamentos()) {
	//			fec.setOficial(ofic);
				Oficial oficAux = new Oficial(); 
				oficAux.setCpf(ofic.getCpf());
				oficAux.setCartorio(ofic.getCartorio());
				
			
				fec.setOficial(oficAux);
				fechamentos.add(fec);
			}
		}
		return fechamentos;
		
	}


	

	
	private Map<String, Object> criaPametros (RelatorioExtratoOnlineVO valores){
		
		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("USUARIO_INTERNO", true);
		
		parametros.put("EXTRATO_MENSAL_MES_PAGAMENTO", valores.getExtratoMensal().getMesPagamento());
		parametros.put("EXTRATO_MENSAL_VALOR_BRUTO_MENSAL", valores.getExtratoMensal().getValorBrutoMensal() );
		parametros.put("EXTRATO_MENSAL_VALOR_RECIVIL", valores.getExtratoMensal().getValorRecivil());
		parametros.put("EXTRATO_MENSAL_VALOR_UNIMED", valores.getExtratoMensal().getValorUnimed());
		parametros.put("EXTRATO_MENSAL_VALOR_IR", valores.getExtratoMensal().getValorIRRetido());
		parametros.put("EXTRATO_MENSAL_VALOR_RECEBIDO", valores.getExtratoMensal().getValorRecebido());
		parametros.put("EXTRATO_MENSAL_CPF", valores.getExtratoMensal().getCpfPessoa());

		parametros.put("VALORES_PESSOA_MES_NOME", valores.getValoresPorPessoaEMes().getNome());
		parametros.put("VALORES_PESSOA_MES_CPF", valores.getValoresPorPessoaEMes().getCpf());
		parametros.put("VALORES_PESSOA_MES_RG_ORGAO_EXPEDIDOR", valores.getValoresPorPessoaEMes().getRgOrgaoExpedidor());
		parametros.put("VALORES_PESSOA_MES_RG_UF_ORGAO_EXPEDIDOR", valores.getValoresPorPessoaEMes().getRgUFOrgaoExpedidor());
		parametros.put("VALORES_PESSOA_MES_RG", valores.getValoresPorPessoaEMes().getRg());
		// List<Oficial> oficiais
		parametros.put("VALORES_PESSOA_MES_CARTEIRA_FUNCIONAL", valores.getValoresPorPessoaEMes().getDesejaCarteiraFuncional());
		parametros.put("VALORES_PESSOA_FILIAÇÂO_NOME_MAE", valores.getValoresPorPessoaEMes().getFiliacaoNomeMae());
		parametros.put("VALORES_PESSOA_FILIAÇÂO_NOME_PAI", valores.getValoresPorPessoaEMes().getFiliacaoNomePai());
		parametros.put("VALORES_PESSOA_PAI_NAO_DECLARADO", valores.getValoresPorPessoaEMes().getPaiNaoDeclarado());
		parametros.put("VALORES_PESSOA_NATURALIDADE_UF", valores.getValoresPorPessoaEMes().getNaturalidadeUF());
		parametros.put("VALORES_PESSOA_NATURALIDADE_MUNICIPIO", valores.getValoresPorPessoaEMes().getNaturalidadeMunicipio());
		parametros.put("VALORES_PESSOA_DATA_NASCIMENTO", valores.getValoresPorPessoaEMes().getDataNascimento());
		parametros.put("VALORES_PESSOA_DATA_FIM", valores.getValoresPorPessoaEMes().getDataFim());
		
//		parametros.put("FECHAMENTO",new JRBeanCollectionDataSource(separarListaFechamento(valores)));
		// new JRBeanCollectionDataSource(separarListaFechamento(valores))
		
		
		return parametros;
		
	}

}






