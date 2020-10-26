$(function(){
	$('button[type=button]').on('click',function(){
		let name=$('input[name=name]').val();
		let age=$('input[name=age]').val();
		let email=$('input[name=email]').val();
		let gender=$('input:radio:checked').val();
		let re=/^[a-z0-9]{3,12}$/i;
		if(!re.test(name)){
			alert('name不合法！');
			return;
		}
		re=/^(1[6-9]|[23]\d|40)$/;
		if(!re.test(age)){
			alert('age不合法！');
			return;
		}
		re=/^\w+@\w+$/;
		if(!re.test(email)){
			alert('email不合法！');
			return;
		}
		let tr=$("<tr>");
		$("<td>").text(name).appendTo(tr);
		$("<td>").text(age).appendTo(tr);
		$("<td>").text(gender).appendTo(tr);
		$("<td>").text(email).appendTo(tr);
		tr.appendTo($('tbody'));
	});
});