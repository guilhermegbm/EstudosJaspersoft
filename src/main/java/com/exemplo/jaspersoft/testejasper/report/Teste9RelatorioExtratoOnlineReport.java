package com.exemplo.jaspersoft.testejasper.report;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Fechamento;
import com.exemplo.jaspersoft.testejasper.entity.FechamentoRubrica;
import com.exemplo.jaspersoft.testejasper.entity.Oficial;
import com.exemplo.jaspersoft.testejasper.vo.RelatorioExtratoOnlineVO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class Teste9RelatorioExtratoOnlineReport {


	public void gerarRelatorioExtratoOnline(RelatorioExtratoOnlineVO valores) throws Exception {

		String destino = "C:\\Users\\mariana\\Desktop\\reports_gerados\\Teste9.pdf";

		String origemPai = "C:\\Users\\mariana\\Documents\\apisBk\\testejasper\\src\\main\\resources\\relatorios\\Teste9_RelatorioExtratoOnline.jrxml";

		RelatorioPdfUtil.printDecompiledReportWithCustomCollectionDataSource(destino, origemPai, criaPametros(valores),
				gerarDataSet(valores));

	}

	private List<HashMap<String, Object>> gerarDataSet(RelatorioExtratoOnlineVO vo) throws JRException {

		List<Fechamento> fechamentos = this.separarListaFechamento(vo);

		List<HashMap<String, Object>> dataSet = new ArrayList<HashMap<String, Object>>();

		for (Fechamento fec : fechamentos) {
			HashMap<String, Object> item = new HashMap<String, Object>();

			item.put("fechamento", fec);

			dataSet.add(item);

		}

		return dataSet;

	}

	private List<Fechamento> separarListaFechamento(RelatorioExtratoOnlineVO vo) {

		List<Fechamento> fechamentos = new ArrayList<Fechamento>();

		for (Oficial ofic : vo.getValoresPorPessoaEMes().getOficiais()) {

			for (Fechamento fec : ofic.getFechamentos()) {

				Oficial oficAux = new Oficial();
				oficAux.setCpf(ofic.getCpf());
				oficAux.setCartorio(ofic.getCartorio());
				oficAux.setTipoOficial(ofic.getTipoOficial());
				
				fec.setOficial(oficAux);


				fechamentos.add(fec);
			}
		}
		return fechamentos;

	}


	private Map<String, Object> criaPametros(RelatorioExtratoOnlineVO valores) throws JRException {

		Map<String, Object> parametros = new HashMap<String, Object>();

	
		// Instacia subReport

		String origemSubReportFechamentosRubrica = "C:\\Users\\mariana\\Documents\\apisBk\\testejasper\\src\\main\\resources\\relatorios\\Teste9_RelatorioExtratoOnlineSubReport2FechamentosRubrica.jrxml";

		File fileSubReportFechamentosRubrica = new File(origemSubReportFechamentosRubrica);
		JasperReport jasperSubReportFechamentosRubrica = JasperCompileManager.compileReport(fileSubReportFechamentosRubrica.getAbsolutePath());

//		//Passa subReport2 como paramentro
		parametros.put("SUB_REPORT_FECHAMENTOS_RUBRICA", jasperSubReportFechamentosRubrica);

		// Passa colletion Data Source como paramento


		// paramentros do pai
		parametros.put("USUARIO_INTERNO", true);

		parametros.put("EXTRATO_MENSAL_MES_PAGAMENTO", valores.getExtratoMensal().getMesPagamento());
		parametros.put("EXTRATO_MENSAL_VALOR_BRUTO_MENSAL", valores.getExtratoMensal().getValorBrutoMensal());
		parametros.put("EXTRATO_MENSAL_VALOR_RECIVIL", valores.getExtratoMensal().getValorRecivil());
		parametros.put("EXTRATO_MENSAL_VALOR_UNIMED", valores.getExtratoMensal().getValorUnimed());
		parametros.put("EXTRATO_MENSAL_VALOR_IR", valores.getExtratoMensal().getValorIRRetido());
		parametros.put("EXTRATO_MENSAL_VALOR_RECEBIDO", valores.getExtratoMensal().getValorRecebido());
		parametros.put("EXTRATO_MENSAL_CPF", valores.getExtratoMensal().getCpfPessoa());

		parametros.put("VALORES_PESSOA_MES_NOME", valores.getValoresPorPessoaEMes().getNome());
		parametros.put("VALORES_PESSOA_MES_CPF", valores.getValoresPorPessoaEMes().getCpf());
		parametros.put("VALORES_PESSOA_MES_RG_ORGAO_EXPEDIDOR",
				valores.getValoresPorPessoaEMes().getRgOrgaoExpedidor());
		parametros.put("VALORES_PESSOA_MES_RG_UF_ORGAO_EXPEDIDOR",
				valores.getValoresPorPessoaEMes().getRgUFOrgaoExpedidor());
		parametros.put("VALORES_PESSOA_MES_RG", valores.getValoresPorPessoaEMes().getRg());
		// List<Oficial> oficiais
		parametros.put("VALORES_PESSOA_MES_CARTEIRA_FUNCIONAL",
				valores.getValoresPorPessoaEMes().getDesejaCarteiraFuncional());
		parametros.put("VALORES_PESSOA_FILIAÇÂO_NOME_MAE", valores.getValoresPorPessoaEMes().getFiliacaoNomeMae());
		parametros.put("VALORES_PESSOA_FILIAÇÂO_NOME_PAI", valores.getValoresPorPessoaEMes().getFiliacaoNomePai());
		parametros.put("VALORES_PESSOA_PAI_NAO_DECLARADO", valores.getValoresPorPessoaEMes().getPaiNaoDeclarado());
		parametros.put("VALORES_PESSOA_NATURALIDADE_UF", valores.getValoresPorPessoaEMes().getNaturalidadeUF());
		parametros.put("VALORES_PESSOA_NATURALIDADE_MUNICIPIO",
				valores.getValoresPorPessoaEMes().getNaturalidadeMunicipio());
		parametros.put("VALORES_PESSOA_DATA_NASCIMENTO", valores.getValoresPorPessoaEMes().getDataNascimento());
		parametros.put("VALORES_PESSOA_DATA_FIM", valores.getValoresPorPessoaEMes().getDataFim());

		return parametros;

	}



}
