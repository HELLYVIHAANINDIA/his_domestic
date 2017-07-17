package com.hisd.common.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hisd.common.services.CommonService;

@Service
//@EnableScheduling
public class Annotation {
	@Autowired
	private SpringMailSender mailSender;
	
	@Autowired
	private CommonService commonService;
	
	
	@Scheduled(cron ="*/10 * * * * *")
	
	public void fixedDelayTask() throws Exception {
/*	Cron expression : second, minute, hour, day of month, month, day(s) of week	
 * 0 - is for seconds

		1- 1 minute

		1 - hour of the day.*/
//		boolean isSent = false;
//		System.out.println(new Date() + " This runs in a fixed delay");
//		String mailmessageids = null;
//		List<TblMailMessage> list = commonService.getTblMailMessage();
//		if(list!=null && list.size() > 0){
//			int i=0;
//			mailmessageids = new String("");
//			for (TblMailMessage tblMailMessage : list) {
//				isSent = mailSender.sendMail("User", tblMailMessage.getMailBody(), tblMailMessage.getMailFrom(),tblMailMessage.getMailTo(), tblMailMessage.getMailSubject());
//				if(isSent){
//					mailmessageids = mailmessageids  + tblMailMessage.getMailmessageid() + "," ;
//				}
//				i++;
//			}
//			if(mailmessageids!=null && !mailmessageids.equalsIgnoreCase("")){
//				commonService.updateTblMailMessage(mailmessageids.substring(0, mailmessageids.length()-1));
//				System.out.println(new Date() + " All mails has been sent successfully");
//			}
//		}else{
//			System.out.println(new Date() + " Empty Queue");
//		}
		
	}

//	@Scheduled(fixedRate = 6000)
	public void fixedRateTask() {
		System.out.println(new Date() + " This runs in a fixed rate");
	}

//	@Scheduled(fixedRate = 7000, initialDelay = 2000)
	public void fixedRateWithInitialDelayTask() {
		System.out.println(new Date() + " This runs in a fixed delay with a initial delay");
	}

//	@Scheduled(cron = "10 * * * * *")
	public void cronTask() {
		System.out.println(new Date() + " This runs in a cron schedule");
	}
}