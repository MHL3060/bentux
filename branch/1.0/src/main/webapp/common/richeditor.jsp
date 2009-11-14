<%@ include file="/common/taglibs.jsp" %>
<script src="ckeditor/ckeditor.js" type="text/javascript"></script>
<script type="text/javascript">
  window.onload = function() {
    var oFCKeditor = new FCKeditor( 'header_message' ) ;
    oFCKeditor.BasePath = "<c:url value="/ckeditor/" />";
    oFCKeditor.ReplaceTextarea() ;
    
    var oFCKeditor2 = new FCKeditor( 'thankyou_message' ) ;
    oFCKeditor2.BasePath = "<c:url value="/ckeditor/" />";
    oFCKeditor2.ReplaceTextarea() ;
  }
</script>