package com.example.infrastructure.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.example.domain.entity.Cliente;
import com.example.domain.entity.Cliente.Cliente_;
import com.example.domain.entity.enums.TipoDocumentoEnum;
import com.example.infrastructure.repository.ClienteRepositoryCustom;
import com.example.infrastructure.repository.shared.AbstractDAO;

public class ClienteRepostoryImpl extends AbstractDAO<Cliente> implements ClienteRepositoryCustom  {		
	private static final long serialVersionUID = 3708363973259424488L;

	@Override
	public Cliente listClientesComCPF(String numero) {		
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq(Cliente_.TIPO_DOCUMENTO, TipoDocumentoEnum.CPF));
		criteria.add(Restrictions.eq(Cliente_.NUMERO_DOCUMENTO, numero));
		return (Cliente) executeCriteriaUniqueResult(criteria);
	}

}
