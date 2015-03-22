1). find the id of the textarea you want to replace. in this case, I will use "description" as the id.

2). include <%@ include file="/common/taglibs.jsp" %>

3). add the following after the head tag



&lt;script type="text/javascript"&gt;


> window.onload = function() {
> > CKEDITOR.replace( 'description' );

> }


&lt;/script&gt;




note: it seems Chrome doesn't support this rich Edit well. it display anomaly.


