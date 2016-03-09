package com.hkbu.service.impl;

import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import com.hkbu.domain.Dep;
import com.hkbu.dao.DepDao;
import com.hkbu.service.DepService;
import org.springframework.stereotype.Service;

@Service(value="depService")
@Transactional
public class DepServiceImpl implements DepService
{

	@Resource(name="depDao")
	private DepDao depDao;

}