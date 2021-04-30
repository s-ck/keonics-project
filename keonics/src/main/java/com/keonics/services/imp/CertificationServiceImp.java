package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Certification;
import com.keonics.modal.CertificationDao;
import com.keonics.services.CertificationService;

@Service
public class CertificationServiceImp implements CertificationService{

	private CertificationDao certifcationDao;
	
	@Autowired
	public CertificationServiceImp(CertificationDao certificationDao) {
		
		this.certifcationDao = certificationDao;
		
	}
	
	@Override
	@Transactional
	public List<Certification> getCertifications() {
		
		return certifcationDao.getCertifications();
		
	}
	
	@Override
	@Transactional
	public List<Certification> getCertifications(int id) {
		
		return certifcationDao.getCertifications(id);
		
	}

	@Override
	@Transactional
	public Certification addCertification(Certification certification) {
		
		return certifcationDao.addCertification(certification);
		
	}

	@Override
	@Transactional
	public Certification deleteCertification(int id) {
		
		return certifcationDao.deleteCertification(id);
		
	}

}
