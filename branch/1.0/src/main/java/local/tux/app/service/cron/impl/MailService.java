package local.tux.app.service.cron.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.transaction.Synchronization;

import org.springframework.mail.MailSender;

import local.tux.SendHtmlMailService;
import local.tux.app.service.MailManager;
import local.tux.app.service.cron.TuxCronTask;

public class MailService implements TuxCronTask {

	private SendHtmlMailService sendHtmMailSender;
	private static List<MimeMessage> mailHolder = new ArrayList<MimeMessage>();
	public void addMessage(MimeMessage mimeMessage) {
		synchronized (mailHolder) {
			mailHolder.add(mimeMessage);
		}

	}

	
	
	public void setSendHtmMailSender(SendHtmlMailService sendHtmMailSender) {
		this.sendHtmMailSender = sendHtmMailSender;
	}

	public void execute() {
		
		synchronized (mailHolder) {
			for (Iterator<MimeMessage> i =  mailHolder.iterator(); i.hasNext();){
				MimeMessage message = i.next();
				sendHtmMailSender.sendMimeMessage(message);
				i.remove();
			}
		}
	}

}
