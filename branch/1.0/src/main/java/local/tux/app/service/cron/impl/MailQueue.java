package local.tux.app.service.cron.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.quartz.QuartzJobBean;

import local.tux.SendHtmlMailService;
import local.tux.app.service.cron.TuxCronTask;

public class MailQueue implements TuxCronTask{

	private JavaMailSenderImpl mailSender;
	private static List<MimeMessage> mailHolder = new ArrayList<MimeMessage>();
	public void addMessage(MimeMessage mimeMessage) {
		synchronized (mailHolder) {
			mailHolder.add(mimeMessage);
		}

	}
	
	public MimeMessage createMimeMessage(){
		return mailSender.createMimeMessage();
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = (JavaMailSenderImpl) mailSender;
	}

	public void execute(){
			
		
		synchronized (mailHolder) {
			for (Iterator<MimeMessage> i =  mailHolder.iterator(); i.hasNext();){
				MimeMessage message = i.next();
				mailSender.send(message);
				i.remove();
			}
		}
		
	}


}
