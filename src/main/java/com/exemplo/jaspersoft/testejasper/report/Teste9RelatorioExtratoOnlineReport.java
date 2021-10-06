package com.exemplo.jaspersoft.testejasper.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.exemplo.jaspersoft.testejasper.entity.Oficial;
import com.exemplo.jaspersoft.testejasper.vo.RelatorioExtratoOnlineVO;

@Component
public class Teste9RelatorioExtratoOnlineReport {

	public void gerarRelatorioExtratoOnline(String destino, String origem, RelatorioExtratoOnlineVO valores)
			throws Exception {

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





		
		
		
		
		RelatorioPdfUtil.printDecompiledReportWithEmptyDataSource(destino, parametros, origem);
	}
	

}






