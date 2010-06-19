<html>
<head>
<title>Capcha Validation</title>
<style>
.errorMessage {
color: red;
font-size: 0.8em;
} 

.label {
color:#000000;
}
</style>
</head>
<body>
<table>
<tr>
<td>
<h1>Captcha Validation</h1>
<form action="doCaptcha" method="POST">
<actionerror /> 
<img src="jcaptcha" border="0">
<textfield label="Code" name="j_captcha_response" size="20" maxlength="10"/>
<submit value="Verify" align="center" />
<form>
</td>
</tr>
</table>
</body>
</html>