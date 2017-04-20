package com.hisd.common.services;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.logging.FileHandler;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.LogRecord;
/*import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hisd.common.model.TblExceptionLog;

@Service
public class ExceptionHandlerService extends Exception {

    public ExceptionHandlerService() {
    }

    public ExceptionHandlerService(boolean exceptionLogToFile, Throwable throwable) {
        super(throwable);
        this.exceptionLogToFile = exceptionLogToFile;
    }

    public boolean addTblErrorLogDetails(TblExceptionLog tblExceptionLog) throws Exception {
        boolean bSuccess = false;
        bSuccess = true;
        return bSuccess;
    }

    private static final Logger LOG = Logger.getLogger("eProcurement");
    private String erroMessage = "";
    private @Value("#{projectProperties['exception.printstrackon']?:false}")
    boolean isPrintStackTrace;
    private @Value("#{projectProperties['exception.logfile']?:false}")
    boolean exceptionLogToFile;
    private @Value("#{projectProperties['exception.database']?:false}")
    boolean exceptionLogToDatabase;
    private @Value("#{projectProperties['exception.mail']?:false}")
    boolean exceptionLogToMail;
    private @Value("#{projectProperties['exception.mailto']}")
    String exceptionMailTo;
    private @Value("#{projectProperties['log.location']}")
    String logLocation;

    public String writeLog(Throwable e) {
        if (isPrintStackTrace) {
            e.printStackTrace();
        }

        logToDatabase(e);
        logToMail(e);
        logToFile(e);
        return "redirect:/exception";
    }

    public void logToFile(Throwable e) {
        if (exceptionLogToFile) {
            try {
            	StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
            	LOG.error(sw.toString());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void logToDatabase(Throwable e) {
        if (exceptionLogToDatabase) {
        	try {
	            StringBuilder str = new StringBuilder();
	            str.append("[Error in File = ]");
	
	            String fileName = e.getStackTrace()[0].getFileName();
	            str.append(fileName);
	            str.append("[Error Class = ]");
	            String className = e.getStackTrace()[0].getClassName();
	            str.append(className);
	            str.append("\n");
	            str.append("[Error Method Name= ]");
	            String methodName = e.getStackTrace()[0].getMethodName();
	            str.append(methodName);
	            str.append("\n");
	            str.append("[Error Line Number = ]");
	            int lineNumber = e.getStackTrace()[0].getLineNumber();
	            str.append(lineNumber);
	            this.erroMessage = str.toString();
	
	            TblExceptionLog tblExceptionLog = new TblExceptionLog();
	            tblExceptionLog.setFileName(fileName);
	            tblExceptionLog.setClassName(className);
	            tblExceptionLog.setMethod(methodName);
	            tblExceptionLog.setLineNumber(lineNumber);
	            tblExceptionLog.setErrorMessage(e.getMessage() == null ? "" : e.getMessage());
	            //tblExceptionLog.setCreatedBy(formatter.getUserId());
	            tblExceptionLog.setLinkId(0);
           
                addTblErrorLogDetails(tblExceptionLog);

            } catch (Exception ex) {
                //System.out.println("Error while storing error log details into Database.");
                ex.printStackTrace();
            }
        }

    }

    public void logToMail(Throwable e) {
        if (exceptionLogToMail) {
        	try {
	            List<StackTraceElement> eprocureStackTraceElements = new ArrayList<StackTraceElement>();
	            for (StackTraceElement element : e.getStackTrace()) {
	                if (element.getClassName().contains("com.hisd")) {
	                    eprocureStackTraceElements.add(element);
	                }
	            }
	
	            if (eprocureStackTraceElements == null || eprocureStackTraceElements.size() == 0) {
	                eprocureStackTraceElements.add(e.getStackTrace()[0]);
	            }
	
	            StringBuilder str = new StringBuilder();
	            str.append("<table border='2' cellspacing='2' cellpading='2' align='center' bordercolor='black'><tr>");
	            str.append("<th>Error in File</th>");
	            str.append("<th>Error Class</th>");
	            str.append("<th>Error Method Name</th>");
	            str.append("<th>Error Line Number</th>");
	            str.append("<th>Error Message</th>");
	            str.append("<th>User Id</th></tr>");
	
	            for (StackTraceElement stackTraceElement : eprocureStackTraceElements) {
	                str.append("<tr><td>");
	                String fileName = stackTraceElement.getFileName();
	                str.append(fileName);
	                str.append("</td><td>");
	
	                String className = stackTraceElement.getClassName();
	                str.append(className);
	                str.append("</td><td>");
	
	                String methodName = stackTraceElement.getMethodName();
	                str.append(methodName);
	                str.append("</td><td>");
	
	                int lineNumber = stackTraceElement.getLineNumber();
	                str.append(lineNumber);
	                str.append("</td><td>");
	                str.append(e.getMessage());
	                str.append("</td><td>");
	
	                //str.append(formatter.getUserId());
	                str.append("</td></tr>");
	            }
	
	            str.append("</table>");
	            this.erroMessage = str.toString();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getErrorMessage() {
        return erroMessage;
    }

    /*private class MyFormatter extends Formatter {

    	private ServletRequestAttributes attr = null;
        private final DateFormat DF = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

        @Override
        public String format(LogRecord record) {
            StringBuilder builder = new StringBuilder(1000);
            builder.append("Start:::-------------------------------------------------------------------------");
            builder.append("\n");
            builder.append("User Id::::::").append(getUserId());
            builder.append("\n");
            builder.append("---------------------------------------------------------------------------------");
            builder.append("\n");
            builder.append(DF.format(new Date(record.getMillis()))).append(" - ");
            builder.append("[").append(record.getSourceClassName()).append(".");
            builder.append(record.getSourceMethodName()).append("] - ");
            builder.append("[").append(record.getLevel()).append("] - ");
            builder.append(formatMessage(record));
            builder.append("\n");
            return builder.toString();
        }*/
        
        /*private ServletRequestAttributes getCurrentRequestAttribute(){
        	if(attr==null){
        		attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        	}
			return attr;
        }*/
        
        public int getUserId() {
            return 1;
        }
        
    }
//}