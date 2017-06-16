package com.niit.AyuProduct_Frontend.FileInput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileInput 
{
   public static void upload(String path,MultipartFile file,String fileName)
   {
	   if(!file.isEmpty())//tells that if the file is not empty
	   {
		   InputStream inputStream = null;
		   OutputStream outputStream = null;
		    if(file.getSize()>0)
		    {
		    	try
		    	{
		    		inputStream=file.getInputStream();
		    		outputStream=new FileOutputStream(path+fileName);
		    		System.out.println("\t Done with the Intialization of FileInputStream and FileOutputStream");
		    		int readBytes=0;
		    		System.out.println("\t Done with the Intialization of ReadByte to 0");
		    		byte buffer [] =new byte[1024]; 
		    		System.out.println("\t Done with the Intialization of Buffer bye to 1024");
		    		while((readBytes = inputStream.read(buffer, 0, 1024))!= -1)
		    		{
		    			outputStream.write(buffer, 0, readBytes);
		    		}

		    	}
		    	catch(IOException io)
		    	{
		    		System.out.println("\t YOU HAVE SOME ERROR IN THE FILEINPUT.JAVA IN FRONTEND OF IO ");
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("\t YOU HAVE SOME ERROR IN THE FILEINPUT.JAVA IN FRONTEND OF OTHER EXCEPTION CLASS ");
		    	}
		    	catch(Throwable t)
		    	{
		    		System.out.println("\t YOU HAVE SOME ERROR IN THE FILEINPUT.JAVA IN FRONTEND OF THROWABLE CLASS ");
		    	}
		    	finally
		    	{
		    		try
		    		{
		    			inputStream.close();
		    			outputStream.close();
		    		}
		    		catch(IOException io)
			    	{
			    		System.out.println("\t YOU HAVE SOME ERROR IN THE FILEINPUT.JAVA IN FRONTEND OF IO WHILE CLOSING ");
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println("\t YOU HAVE SOME ERROR IN THE FILEINPUT.JAVA IN FRONTEND OF OTHER EXCEPTION CLASS WHILE CLOSING ");
			    	}
			    	catch(Throwable t)
			    	{
			    		System.out.println("\t YOU HAVE SOME ERROR IN THE FILEINPUT.JAVA IN FRONTEND OF THROWABLE CLASS WHILE CLOSING");
			    	}
		    	}
		    }
	   }
   }
}
