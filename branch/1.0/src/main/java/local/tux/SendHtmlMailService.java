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
 */
public class SendHtmlMailService {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
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
	 * @throws MessagingException
	 */
	public void sendHtmlMessage(final SimpleMailMessage mailMessage,
			final String templateName, final Map<String, File> attachements,
			final Map<String, Object> model) throws MessagingException {

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
				// for inline image, the order is very important.
				// so it have to add them at the end.
				if (hasInLineImage) {
					Set<String> imageNames = attachements.keySet();
					for (String imageName : imageNames) {
						File file = attachements.get(imageName);
						message.addInline(imageName, file);
					}
				}
			}
		};

		((JavaMailSenderImpl) mailSender).send(preparator);
	}

	public void sendMimeMessage(final MimeMessage mimeMessage) {

		((JavaMailSenderImpl) mailSender).send(mimeMessage);
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

}