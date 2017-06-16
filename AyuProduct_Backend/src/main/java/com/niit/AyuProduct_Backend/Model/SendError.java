package com.niit.AyuProduct_Backend.Model;

public class SendError 
{ 
   int errorCode;
   String message;
   String status;
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}
public String getMessageError() {
	return message;
}
public void setMessageError(String message) {
	this.message = message;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
