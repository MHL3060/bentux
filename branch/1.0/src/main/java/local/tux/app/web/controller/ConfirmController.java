package local.tux.app.web.controller;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import local.tux.Constants;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.web.common.controller.TuxBaseFormController;


import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.apache.commons.lang.StringUtils;
import org.appfuse.service.UserManager;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

public class ConfirmController extends TuxBaseFormController {

	private String submitPage;
	private String editPage;

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
		
	private ShoppingCartManager shoppingCartManager;
	private UserManager userManager;
	
	public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

	public void setVelocityEngine(VelocityEngine velocityEngine) {
	      this.velocityEngine = velocityEngine;
	}

	public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
		this.shoppingCartManager = shoppingCartManager;
	}
	public void setUserManager(UserManager userManager){
		this.userManager = userManager;
	}

	public void setSubmitPage(String submitPage){
		this.submitPage = submitPage;
	}
	public void setEditPage(String editPage){
		this.editPage = editPage;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav;
		if (StringUtils.isBlank(request.getParameter("submit")) == false){
			mav = new ModelAndView(submitPage);
			return mav;
		}else if (StringUtils.isBlank(request.getParameter("edit"))== false){
			mav = new ModelAndView(editPage);
			return mav;
		}else {
			mav = new ModelAndView();
			ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
			ShippingAddress address = (ShippingAddress) request.getSession().getAttribute(Constants.ADDRESS_SESSION);
			mav.addObject("cartItems", cart.getShoppingItems());
			mav.addObject("shippingAddress", address);
			return mav;
		}
	}

		
	private void sendConfirmationEmail() {
		      MimeMessagePreparator preparator = new MimeMessagePreparator() {
		         public void prepare(MimeMessage mimeMessage) throws Exception {
		            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
		            message.setFrom("order@shopattrinity.com"); // could be parameterized...
		            Map model = new HashMap();
		            model.put("title", "avx");
		            String text = VelocityEngineUtils.mergeTemplateIntoString(
		               velocityEngine, "secondaryTemplate.vm", model);
		            message.setText(text, true);
		         }
		      };
		      this.mailSender.send(preparator);
	}
}
