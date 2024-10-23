package com.laci.jaxb.jaxbxjc;

import com.bharatthippireddy.patient.Patient;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBDemo {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Patient patient = new Patient();
			patient.setName("Laci");
			patient.setId(123);
			
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(patient, stringWriter);
			
			System.out.println(stringWriter.toString());
			
			StringReader stringReader = new StringReader(stringWriter.toString());
			
			Patient patientResponse = (Patient) unmarshaller.unmarshal(stringReader);
			
			
			System.out.println(patientResponse.getName());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
