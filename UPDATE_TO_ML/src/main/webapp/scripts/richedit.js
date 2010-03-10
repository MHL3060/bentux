function textCounter1(field, countfield, maxlimit) {
	if (field.value.length > maxlimit) // if too long...trim it!
		field.value = field.value.substring(0, maxlimit);
	else
		// otherwise, update counter
		countfield.value = field.value.length;
}

function textCounter2(field, countfield, maxlimit) {
	if (field.value.length > maxlimit) // if too long...trim it!
		field.value = field.value.substring(0, maxlimit);
	else
		// otherwise, update counter
		countfield.value = field.value.length;
}


//--


