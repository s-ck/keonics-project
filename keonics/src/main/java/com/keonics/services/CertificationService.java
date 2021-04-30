package com.keonics.services;

import java.util.List;

import com.keonics.entity.Certification;

public interface CertificationService {

	public List<Certification> getCertifications();
	
	public List<Certification> getCertifications(int id);
	
	public Certification addCertification(Certification certification);
	
	public Certification deleteCertification(int id);
	
}
