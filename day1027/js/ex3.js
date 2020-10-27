$(function(){
	function User(name,age,gender,email){
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.email=email;
	}

	let users=[];
	let ascOrder=true;

	let reAge=/^(1[6-9]|[23]\d|40)$/;
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
		if(!reAge.test(age)){
			alert('age不合法！');
			return;
		}
		re=/^\w+@\w+$/;
		if(!re.test(email)){
			alert('email不合法！');
			return;
		}
		let u=new User(name,age,gender,email);
		users.push(u);
		addUser2Table(u);
	});

	$('thead th:eq(1)').on('click',function(){
		users.sort((a,b)=>a.age-b.age);
		if(!ascOrder){
			users.reverse();
		}
		ascOrder=!ascOrder;
		$('tbody').empty();
		for(let i in users){
			addUser2Table(users[i]);
		}
	});

	function addUser2Table(user){
		let tr=$("<tr>");
		$("<td>").text(user.name).appendTo(tr);
		tr.append(createAgeTd(user.age));
		$("<td>").text(user.gender).appendTo(tr);
		$("<td>").text(user.email).appendTo(tr);
		tr.append(createModifyTd());
		tr.appendTo($('tbody'));
	}

	$("tbody").on('click','.btnModify',function(){
		let td=$(this).parents("tr").find('td:eq(1)');
		td.find('span').toggle();
		$(this).parents("td").find('span').toggle();
		let age=td.find('span:eq(0)').text();
		td.find('input').val(age);
	});
	$("tbody").on('click','.btnCancel',function(){
		$(this).parents("tr").find('td:eq(1) span').toggle();
		$(this).parents("td").find('span').toggle();
	});
	$("tbody").on('click','.btnConfirm',function(){
		let tr=$(this).parents("tr")
		let td=tr.find('td:eq(1)');
		let age=td.find('input').val();
		if(!reAge.test(age)){
			alert('age不合法！');
			return;
		}
		let index=$('tbody tr').index(tr);
		users[index].age=age;
		td.find('span:eq(0)').text(age);
		td.find('span').toggle();
		$(this).parents("td").find('span').toggle();
	});

	function createAgeTd(age){
		let td=$('<td>');
		$('<span>').text(age).appendTo(td);
		$('<span>').append($("<input size='3'>")).hide().appendTo(td);
		return td;
	}
	function createModifyTd(){
		let td=$('<td>');
		let btn=$('<button>').text('Modify').addClass('btnModify');
		$('<span>').append(btn).appendTo(td);
		let btnCon=$('<button>').text('Confirm').addClass('btnConfirm');
		let btnCan=$('<button>').text('Cancel').addClass('btnCancel');
		$('<span>').append(btnCon).append(btnCan).hide().appendTo(td);
		return td;
	}
});