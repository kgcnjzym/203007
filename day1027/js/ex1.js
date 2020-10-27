$(function(){
	let imgs=['imgs/adv_1.jpg','imgs/adv_2.jpg','imgs/adv_3.jpg','imgs/adv_4.jpg','imgs/lady_0007.jpg'];
	let tipText=['周年庆','双十一大促','优惠商品','特价处理','牛仔裤'];
	let timer;
	let index=0;
	let divImg=$('.img');
	let divContainer=$('.container');
	let imgWidth=divContainer.width();
	let imgHeight=divContainer.height();
	divImg.width((imgs.length+1)*imgWidth);
	for(let i=0;i<=imgs.length;i++){
		let img=$('<img>').attr('src',imgs[i%imgs.length])
		.width(imgWidth).height(imgHeight);
		divImg.append(img);
	}
	for(let i=0;i<imgs.length;i++){
		$('<li>').text(i+1).appendTo('.indicator');
	}
	function moveImage(){
		index++;
		let ml=-1*imgWidth*index;
		if(index==imgs.length){
			divImg.animate({'margin-left':ml+'px'},1000,function(){
				divImg.css({'margin-left':'0px'});
			});
			index=0;
		}
		else{
			divImg.animate({'margin-left':ml+'px'},1000);
		}
		$('.indicator li').removeClass('curr');
		$('.indicator li:eq('+index+')').addClass('curr');
		$('.tips li').text(tipText[index]);
		timer=setTimeout(moveImage,2000);
	}
	timer=setTimeout(moveImage,2000);
	$('.indicator li:eq(0)').addClass('curr');
	$('.tips li').text(tipText[0]);

	$('.indicator').on('mouseover','li',function(){
		clearTimeout(timer);
		divImg.stop(true);
		let idx=$('.indicator li').index(this);
		$('.tips li').text(tipText[idx]);
		let ml=-1*imgWidth*idx;
		divImg.css({'margin-left':ml+'px'});
		$('.indicator li').removeClass('curr');
		$(this).addClass('curr');
	});

	$('.indicator').on('mouseout','li',function(){
		let idx=$('.indicator li').index(this);
		index=idx-1;
		moveImage();
	});

});