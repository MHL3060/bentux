package local.tux.app.service;

import javax.mail.internet.MimeMessage;

public interface MailManager {

	public void addMessage(MimeMessage mimeMessage);
	public void send();
}
