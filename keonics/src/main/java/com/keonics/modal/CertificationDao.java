package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Certification;

public interface CertificationDao {

	public List<Certification> getCertifications();
	
	public List<Certification> getCertifications(int id);
	
	public Certification addCertification(Certification certification);
	
	public Certification deleteCertification(int id);
	
}
