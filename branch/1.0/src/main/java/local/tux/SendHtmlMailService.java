package local.tux;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import local.tux.app.service.cron.impl.MailQueue;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * class to send html email out. This class is instantiated by the Spring Bean
 * 
 * in your class you can use setMethod to set this class.
 * please note: this class doesn't put the email back to the queue if the smtp has problem
 * to prevent losing mail, you can add your MimeMessage Object to the MailManager.
 * 
 */
public class SendHtmlMailService {

	
	private VelocityEngine velocityEngine;
	private MailQueue mailQueue;


	public void setMailQueue(MailQueue mailQueue){
		this.mailQueue = mailQueue;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	
	/**
	 * 
	 * @param mailMessage
	 * @param templateName
	 * @param attachements
	 * @param model
	 * @throws Exception 
	 */
	public void sendHtmlMessage(final SimpleMailMessage mailMessage,
			final String templateName, final Map<String, File> attachements,
			final Map<String, Object> model) throws Exception {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				boolean hasInLineImage = false;
				MimeMessageHelper message;
				if (attachements != null && attachements.keySet().size() > 0) {
					message = new MimeMessageHelper(mimeMessage, true);
					hasInLineImage = true;
				} else {
					message = new MimeMessageHelper(mimeMessage);
				}
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, templateName, model);
				message.setText(text, true);
				message.setTo(mailMessage.getTo());
				message.setFrom(mailMessage.getFrom());
				message.setSubject(mailMessage.getSubject());
				if (hasInLineImage) {
					Set<String> imageNames = attachements.keySet();
					for (String imageName : imageNames) {
						File file = attachements.get(imageName);
						message.addInline(imageName, file);
					}
				}
			}
		};
		
		MimeMessage mimeMessage = mailQueue.createMimeMessage();
		preparator.prepare(mimeMessage);
		mailQueue.addMessage(mimeMessage);
	}

}