package local.tux.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.appfuse.model.User;

import local.tux.app.model.ShippingAddress;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class AddressFormController extends TuxBaseFormController {

	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		ShippingAddress shippingAddress = (ShippingAddress) super.formBackingObject(request);
		if (StringUtils.isBlank(request.getRemoteUser())== false ) {
			shippingAddress.setUser(getUserManager().getUserByUsername(request.getRemoteUser()));
		}else {
			shippingAddress.setUser(new User());
		}
		return shippingAddress;
	}
}
