package local.tux.app.service.cron.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.scheduling.quartz.QuartzJobBean;

import local.tux.SendHtmlMailService;
import local.tux.app.service.cron.TuxCronTask;

public class MailService implements TuxCronTask{

	private SendHtmlMailService sendHtmMailSender;
	private int timeout;
	private static List<MimeMessage> mailHolder = new ArrayList<MimeMessage>();
	public void addMessage(MimeMessage mimeMessage) {
		synchronized (mailHolder) {
			mailHolder.add(mimeMessage);
		}

	}
	
	public void setSendHtmMailSender(SendHtmlMailService sendHtmMailSender) {
		this.sendHtmMailSender = sendHtmMailSender;
	}

	public void execute(){
			
		
		synchronized (mailHolder) {
			for (Iterator<MimeMessage> i =  mailHolder.iterator(); i.hasNext();){
				MimeMessage message = i.next();
				sendHtmMailSender.sendMimeMessage(message);
				i.remove();
			}
		}
		
	}


}
