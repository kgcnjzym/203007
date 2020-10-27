$(function(){
	$('button').on('click',function(){
		let s=$(':text').val().trim();
		if(s==""){
			return;
		}
		let li=$('<li>');
		$('<span>').text(s).appendTo(li);
		$('<span>').addClass('op').text('完成').appendTo(li);
		$('ul').append(li);
	});
	$('ul').on('click','.op',function(){
		let cmd=$(this).text();
		if(cmd=='完成'){
			$(this).text('删除');
			$(this).prev().addClass('del');
		}
		else{
			$(this).parent().fadeOut(2000,function(){
				$(this).remove();
			});
		}
	});

});