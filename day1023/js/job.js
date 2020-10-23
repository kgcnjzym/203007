onload=function(){
	let btn=document.getElementsByClassName("btn")[0];
	let layer=document.getElementsByClassName("layer")[0];
	let cls=document.getElementsByClassName("close")[0];
	btn.onclick=function(){
		layer.style.display="block";
	};
	cls.onclick=function(){
		layer.style.display="none";
	};

	let cts=['南京','北京','上海','广州','深圳','杭州','无锡','苏州'];
	for(let i=0;i<cts.length;i++){
		let sp=document.createElement("span");
		sp.className="city";
		sp.innerHTML=cts[i];
		sp.onclick=function(){
			btn.innerHTML=this.innerHTML;
			layer.style.display="none";
		};
		layer.appendChild(sp);
	}
}