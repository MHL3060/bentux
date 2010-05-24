package local.tux.app.web.controller;


import org.springframework.mail.SimpleMailMessage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.SendHtmlMailService;
import local.tux.Constants.CART_STATUS;
import local.tux.app.model.ShippingAddress;
import local.tux.app.model.ShoppingCart;
import local.tux.app.model.ShoppingItem;
import local.tux.app.model.Subscription;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.service.ShoppingCartManager;
import local.tux.app.service.ShoppingItemManager;
import local.tux.app.web.common.controller.TuxBaseFormController;


import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.springframework.web.servlet.ModelAndView;

public class ConfirmController extends TuxBaseFormController {

        private String submitPage;
        private String editPage;
                
        private ShoppingCartManager shoppingCartManager;
        private UserManager userManager;
        private SendHtmlMailService htmlMailService;
        private String emailTmeplatePath;
        private final String ORIGINAL_ITEM = "originalItem";
    	private ShoppingItemManager shoppingItemManager;
        private LookUpNameGenericManager<ShippingAddress, Long> shippingAddressManager;
        
        public double totalA;
        
        public void setShoppingCartManager(ShoppingCartManager shoppingCartManager){
                this.shoppingCartManager = shoppingCartManager;
        }
        public void setUserManager(UserManager userManager){
                this.userManager = userManager;
        }
    	public void setShoppingItemManager(ShoppingItemManager shoppingItemManager){
    		this.shoppingItemManager = shoppingItemManager;
    	}
        public void setHtmlMailService(SendHtmlMailService htmlMailService){
                this.htmlMailService = htmlMailService;
        }
        public void setSubmitPage(String submitPage){
                this.submitPage = submitPage;
        }
        public void setEditPage(String editPage){
                this.editPage = editPage;
        }
        public void setShippingAddressManager(LookUpNameGenericManager<ShippingAddress, Long> shippingAddressManager){
                this.shippingAddressManager = shippingAddressManager;
        }
        
        public double getTotal(ShoppingCart cart){
        	totalA = 0;
            for (ShoppingItem item : cart.getShoppingItems()){
                    totalA += item.getTotal();
            }
        return totalA;
        }
    	protected Object formBackingObject(HttpServletRequest request) throws Exception {
    		String id = request.getParameter("id");	
    		if (!StringUtils.isBlank(id)) {
    			ShoppingItem item = shoppingItemManager.get(new Long(id));
    			request.getSession().setAttribute(ORIGINAL_ITEM, item.clone());
                return item;
            }else {
            	ShoppingItem item = new ShoppingItem();
            	User user = getUserManager().getUserByUsername(request.getRemoteUser());
            	ShoppingCart cart = shoppingCartManager.getOpenCart(user);
            	item.setShoppingCart(cart == null ? new ShoppingCart() : cart);
            	return item;
            }
    	}
    	
        public ModelAndView handleRequest(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
                
                ModelAndView mav;
                ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
                
                if (StringUtils.isBlank(request.getParameter("submit")) == false){
                        mav = new ModelAndView(submitPage);
                        Map velocityParams = new HashMap();
                        //ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));

                        if (cart != null){
                                
                                sendConfirmationEmail(request.getLocale(), cart, cart.getShippingAddress());
                                cart.setStatus(CART_STATUS.SUBMITTED);
                                shoppingCartManager.save(cart);
                                mav.addObject("total",getTotal(cart));

                             
                        }else {
                                mav.addObject("emptyCart", Boolean.TRUE );
                        }
                        return mav;
                }else if (StringUtils.isBlank(request.getParameter("edit"))== false){
                        mav = new ModelAndView(editPage);
                        return mav;
                }else {
                        mav = new ModelAndView();
                        //ShoppingCart cart = shoppingCartManager.getOpenCart(userManager.getUserByUsername(request.getRemoteUser()));
                        if (cart != null){
                                
                                mav.addObject("cartItems", cart.getShoppingItems());
                                mav.addObject("cart", cart);
                                mav.addObject("total",getTotal(cart));
                        }else {
                                mav.addObject("emptyCart", Boolean.TRUE );
                        }
                        return mav;
                }

        }
    
        private void sendConfirmationEmail(Locale locale, ShoppingCart cart, ShippingAddress address) throws Exception {
                Map velocityparams = new HashMap();
                velocityparams.put("cart", cart);
                velocityparams.put("address", address);
                velocityparams.put("title", getText("order.title", locale));
                velocityparams.put("bodyContent", getText("body.content", locale));
                
                double total = getTotal(cart);
                velocityparams.put("subTotal", total);
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(cart.getUser().getEmail());
                mailMessage.setFrom("automation@shopattrinity.com");
                mailMessage.setSubject(getText("cart.email.subject", locale));
                htmlMailService.sendHtmlMessage(mailMessage, templateName,null, velocityparams);
                     
        }
}