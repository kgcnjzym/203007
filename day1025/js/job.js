onload=function(){
	let btn=document.getElementsByClassName("btn")[0];
	let layer=document.getElementsByClassName("layer")[0];
	let cls=document.getElementsByClassName("close")[0];
	let cfm=document.getElementsByClassName("confirm")[0];
	btn.onclick=function(){
		layer.style.display="block";
	};
	cls.onclick=function(){
		layer.style.display="none";
	};
	cfm.onclick=function(){
		let chks=document.getElementsByName('chkCity');
		let s="";
		for(let i=0;i<chks.length;i++){
			if(chks[i].checked){
				s+=chks[i].value+" ";
			}
		}
		btn.innerHTML=s;
		layer.style.display="none";
	};

	let cts=['南京','北京','上海','广州','深圳','杭州','无锡','苏州'];
	let cnt=0;
	for(let i=0;i<cts.length;i++){
		let sp=document.createElement("span");
		sp.className="city";
		let chk=document.createElement("input");
		chk.type="checkbox";
		chk.name='chkCity';
		chk.value=cts[i];
		chk.onchange=function(){
			if(this.checked){
				cnt++;
				if(cnt==4){
					this.checked=false;
					cnt--;
				}
			}
			else{
				cnt--;
			}
		}
		sp.appendChild(chk);
		sp.appendChild(document.createTextNode(cts[i]));
		
		layer.appendChild(sp);
	}
}