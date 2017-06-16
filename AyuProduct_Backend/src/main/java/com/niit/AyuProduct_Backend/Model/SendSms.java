package com.niit.AyuProduct_Backend.Model;

public class SendSms extends SendError
{
  private long From = 0l;
  private long To =0l;
  private String Message =null;
  private String Subject=null;

  public long getFrom() 
  {
	return From;
 }
public void setFrom(long from) {
	From = from;
}
public long getTo() {
	return To;
}
public void setTo(long to) {
	To = to;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public String getSubject() {
	return Subject;
}
public void setSubject(String subject) {
	Subject = subject;
}
}