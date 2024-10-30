package com.bharath.ws.soap.dto;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

// mappeli az XML-hez a class -> XmlType
@XmlType(name = "PaymentProcessorRequest")
// ennek segítségével a fieldek feletti annotáció definiálható, plusz tulajdonságok adhatók
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentProcessorRequest {

	@XmlElement(name="creditCardInfo", required = true)
	private CreditCardInfo creditCardInfo;
	@XmlElement(name="amount")
	private Double amount;

	public CreditCardInfo getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
