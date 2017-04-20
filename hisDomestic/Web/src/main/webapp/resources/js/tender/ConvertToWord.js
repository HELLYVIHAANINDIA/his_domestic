function Setup() 
{ 
// set Globals
  Affix = new Array('UNITES', 'THOUSAND', 'LAKH', 'CRORE')
  for(i=1;i<5;i++)
  {
  	Affix[3+i] = Affix[0+i]
  }
  Name = new Array
    ('ZERO', 'ONE', 'TWO', 'THREE', 'FOUR', 'FIVE', 'SIX',
    'SEVEN', 'EIGHT', 'NINE', 'TEN', 'ELEVEN', 'TWELVE',
    'THIRTEEN', 'FOURTEEN', 'FIFTEEN',  'SIXTEEN', 'SEVENTEEN',
    'EIGHTEEN', 'NINETEEN')
  Namety = new Array('TWENTY', 'THIRTY', 'FORTY',
    'FIFTY', 'SIXTY', 'SEVENTY', 'EIGHTY', 'NINETY')
  PointName = new Array
    ('ZERO', 'ONE', 'TWO', 'THREE', 'FOUR', 'FIVE', 'SIX',
    'SEVEN', 'EIGHT', 'NINE')
}

function Small(TC, J, K)
{
  if (J==0) return TC
  if (J>999) return ' Internal ERROR: J = ' + J + ' (>999)'
  var S = TC
  if (J>99) 
  { 
  	S += Name[Math.floor(J/100)] + ' HUNDRED ' ; J %= 100
   	if (J>0) S += 'and '
  }
  else if ((S>'') && (J>0) && (K==0)) S += 'and '
  if (J>19) 
  {
  	 S += Namety[Math.floor(J/10)-2] ; J %= 10 ;
   	 S += ( J>0 ? '-' : ' ') 
  }
  if (J>0) S += Name[J] + ' '
  if (K>0) S += Affix[K] + ' '
  return S 
}

function TextCash(L, K) 
{
	//alert(" L " + L/1000 + " : K " + K);
	if (L==0) return (K>0 ? '' : 'Zero ')
  	if (K==0 || K==3)
  	{
  		return Small(TextCash(Math.floor(L/1000), K+1), L%1000, K)
	}
	else
	{
  		return Small(TextCash(Math.floor(L/100), K+1), L%100, K)
	}
}

function TextCash1(L, K) 
{
	if (L==0) return (K>0 ? '' : 'NIL ')
  		return Small(TextCash1(Math.floor(L/100), K+1), L%100, K)
}

function TextCash2(L, K) 
{
	if (L==0) return (K>0 ? '' : 'NIL ')
  	{
		var pointStr1= new String();
		var pointlen1,pointStr2,pointStr3;
		pointStr2="";
		pointStr3="";
		pointStr1=L;
		pointStr1=pointStr1.toString();
		pointlen1= pointStr1.length;
		//alert(pointStr1);
		for(pointi=0;pointi<pointlen1;pointi++)
		{
			pointStr2=pointStr1.substr(pointi,1);
			if(undefined == PointName[pointStr2])
				continue;
			pointStr3=pointStr3+PointName[pointStr2]+' ';
			//alert(pointStr3);
		}
		return pointStr3;
	}	  	
}

function DoIt(Numeric){ 
	Setup();
	Q = Numeric;
	if (isNaN(parseFloat(Q))){		
    		Word = '';
    	}else{
		//-----------Code by umesh ------------------
		Word=''
		var tempStr1=new String();
		var tempStr3=new String();
		tempStr1=Q;
		tempStr1=tempStr1.toString();
		var tempstr2=tempStr1.search('-');
		if (tempstr2==0){
			Word = 'Minus ';
			//tempStr3='Minus ';
			//tempStr3.fontcolor("red");
			//Word=tempStr3;
		}	
		Q=tempStr1.replace('-','')
		
		var P, pointStr3;
		qStr = Q.toString();
		if(qStr.indexOf(".") != -1){
			qStrAfterPoint = qStr.substring(qStr.indexOf(".")+1, qStr.length);
			P = eval(qStrAfterPoint);
			if(P == 0){
				pointStr3 = '';
			}else{
				var pointStr1= new String();
				var pointlen1,pointStr2;
				pointStr2="";
				pointStr3="";
				pointStr1=qStrAfterPoint;
				pointlen1= pointStr1.length;
	
				for(pointi=0;pointi<pointlen1;pointi++){
					pointStr2=pointStr1.substr(pointi,1);
					if(PointName[pointStr2] != undefined){
						pointStr3=pointStr3+PointName[pointStr2]+' ';
					}
				}
			}
		}else{
			P = 0;
		}
		
		Q = Math.floor(Q)
	  	if (P<=9){
	  		P='0'+P;
	  	}

		R = Q%10000000000;
		if (P==0){	
			if(Q < 10000000000){
				Word = Word + '' + (Q==1?'':'') + '' + TextCash(Q, 0) + '';
			}else{
				Word = Word + '' + (Q==1?'':'') + '' + TextCash(Q, 0) + '';
				if(R == 0){
					Word = Word + 'Crore';
				}
				
				X = Math.floor(Q/10000000);
				if(R!=0 && (X%10) == 0){
					Word = '';
					Word = Word + '' + (X==1?'':'') + '' + TextCash(X, 0) + 'Crore and ';
					Word = Word + '' + (R==1?'':'') + '' + TextCash(R, 0) + '';
				}
			}
		}else{
    			//TextCash2(P, 0)
    			if(Q < 10000000000){
				Word = Word + '' + (Q==1?'':'') + '' + TextCash(Q, 0) + 'point' + ' ' + pointStr3 + '';
			}else{
				Word = Word + '' + (Q==1?'':'') + '' + TextCash(Q, 0);
				if(R == 0){
					Word = Word + 'Crore ';
				}
				Word = Word + 'point' + ' ' + pointStr3 + '';
				
				X = Math.floor(Q/10000000);
				if(R!=0 && (X%10) == 0){
					Word = '';
					Word = Word + '' + (X==1?'':'') + '' + TextCash(X, 0) + 'Crore and ';
					Word = Word + '' + (R==1?'':'') + '' + TextCash(R, 0) + 'point' + ' ' + pointStr3 + '';
				}
			}
		}
  	}
  	return Word
}

function validCriteria(ColValue)
{
	var FValue = parseFloat(ColValue);

	if(parseFloat(FValue) < -10)
	{
		return "#FF0066";
	}
	else if(parseFloat(FValue) >= 5 && parseFloat(FValue) <=10)
	{
		return "#66CC00";
	}
	else if(parseFloat(FValue) >10 && parseFloat(FValue) <=15)
	{
		return "#0000FF";
	}
	else if(parseFloat(FValue) > 15)
	{
		return "#FF0066";
	}
	
		
}

function printpr(print_area,flag,bidderId)
	{
	var disp_setting="toolbar=yes,location=no,status=no,directories=yes,menubar=yes,"; 
      disp_setting+="scrollbars=yes,width=600, height=600, left=100, top=25"; 
	var pp = window.open(); 
   
    pp.document.writeln('<HTML><HEAD><title></title>')
    pp.document.writeln('<LINK href=include/newStyle.css type="text/css" rel="stylesheet">')
    pp.document.writeln('<LINK href=include/PrintStyle.css ' + 
                        'type="text/css" rel="stylesheet" media="print">')
    pp.document.writeln('<base target="_self"></HEAD>')
	pp.document.writeln('<style type="text/css" >#print12 , #htmlView{visibility:hidden;}</style>');
    pp.document.writeln('<body  MS_POSITIONING="GridLayout" bottomMargin="0"');
    pp.document.writeln(' leftMargin="20em" topMargin="0" rightMargin="40em">');
    pp.document.writeln('<form method="post">');
    pp.document.writeln('<INPUT ID="PRINT" type="button" value="Print" ');
    pp.document.writeln('onclick="javascript:location.reload(true);window.print();">');
	pp.document.writeln('<INPUT ID="PRINTPREVIEW" type="button" ' + 
                        'value="PRINTPREVIEW" '+
                        'onclick="printpr1();">');  
                        
                         	                                                            
   	pp.document.writeln('</TD></TR><TR><TD></TD></TR></TABLE>');

   	document.getElementById("pr").style.display='none';    	
   	
   	if(flag=="true"){	
   		document.getElementById("ForHeader").style.display='block';
   	}
   	pp.document.writeln('<TABLE  width=90%><TR><TD align="center"> '+
    					''+
    					'</TD></TR></TABLE>');
	pp.document.writeln(document.getElementById(print_area).innerHTML);
	document.getElementById("pr").style.display='block';  
	
	if(flag=="true"){	
   		document.getElementById("ForHeader").style.display='none';
   	}
    pp.document.writeln('</form></body></HTML>'); 
	
	}
	
	function printpr1()
	{
	 
		var OLECMDID = 7;
		/* OLECMDID values:
		* 6 - printookok
		* 7 - print preview
		* 1 - open window
		* 4 - Save As
		*/
		var PROMPT = 1; // 2 DONTPROMPTUSER 
		var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';																			
		document.body.insertAdjacentHTML('beforeEnd', WebBrowser); 
		WebBrowser1.ExecWB(OLECMDID, PROMPT);
		WebBrowser1.outerHTML = "";
	}
	