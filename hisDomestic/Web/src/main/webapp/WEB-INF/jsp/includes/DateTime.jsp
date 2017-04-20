<script>
    var CLIENT_DATETIME;
    
    var gblServDateTime;
    var intDate;

    var tenderSubmissionDateInt = 0;
    var timerID = 0;
    var cnt=0;
    var Hours = 0;
    var mins=0;
    var monthName='';
    var month=new Array();
    month[0]="Jan";
    month[1]="Feb";
    month[2]="Mar";
    month[3]="Apr";
    month[4]="May";
    month[5]="Jun";
    month[6]="Jul";
    month[7]="Aug";
    month[8]="Sep";
    month[9]="Oct";
    month[10]="Nov";
    month[11]="Dec";
    function UpdateTimer(){
        cnt = cnt+1;
        if(cnt==2){
            cnt=0;
        }	
        intDate = intDate + 1000;
        var tDate = new Date(intDate);
        var yr = tDate.getYear();
	
        if(yr < 1900){
            yr = yr + 1900;		//coz mozilla browser counts year from 1900.
        }

        Hours = tDate.getHours();	
        mins= tDate.getMinutes();
		
        Hours = getFullNumber(Hours);
        mins= getFullNumber(mins);
        if(!isNaN(Hours) && !isNaN(mins)) {
        	var dateFmt='${cookie.dateFormat.value}';
        	var dateFormatString='';
        	//var dateFmt='DD-MMM-YYYY';
        	if(dateFmt == 'DD/MM/YYYY'){
        		dateFormatString="" + getFullNumber(tDate.getDate()) + "/" + getFullNumber((parseInt(tDate.getMonth())+1)) + "/" + yr + " " + Hours + ":" + mins + ":" + getFullNumber(tDate.getSeconds());
                        CLIENT_DATETIME=dateFormatString;
        		dateFormatString += (" " + (('${sessionObject}' !='') ? '${sessionObject.timeZoneAbbr}' : (('${tempSessionObject}' != '') ? '${tempSessionObject.timeZoneAbbr}' : '${clientObject.timeZoneAbbr}')));
            	document.getElementById("lblTime").innerHTML = dateFormatString;
        	}else if(dateFmt == 'MM/DD/YYYY'){
        		dateFormatString="" + getFullNumber((parseInt(tDate.getMonth())+1)) + "/" + getFullNumber(tDate.getDate()) + "/"+ yr + " " + Hours + ":" + mins + ":" + getFullNumber(tDate.getSeconds());
                        CLIENT_DATETIME=dateFormatString;
        		dateFormatString += (" " + (('${sessionObject}' !='') ? '${sessionObject.timeZoneAbbr}' : (('${tempSessionObject}' != '') ? '${tempSessionObject.timeZoneAbbr}' : '${clientObject.timeZoneAbbr}')));
        		document.getElementById("lblTime").innerHTML = dateFormatString;
        	}else if(dateFmt == 'DD MMM YYYY'){
        		dateFormatString="" + getFullNumber(tDate.getDate()) + " " + getFullNumber(month[(parseInt(tDate.getMonth()))]) + " " + yr + " " + Hours + ":" + mins + ":" + getFullNumber(tDate.getSeconds());
                        CLIENT_DATETIME=dateFormatString;
        		dateFormatString += (" " + (('${sessionObject}' !='') ? '${sessionObject.timeZoneAbbr}' : (('${tempSessionObject}' != '') ? '${tempSessionObject.timeZoneAbbr}' : '${clientObject.timeZoneAbbr}')));
        		document.getElementById("lblTime").innerHTML = dateFormatString;
        	}
            $("#currentTime").val(tDate);
        }
    }

    function getTime(){
//    		<abc:ajax method="post" aysnc="false" ajaxurl="ajaxcall/getserverdatetime" isdirectoutput="true" jsvartosetval="gblServDateTime"></abc:ajax>;
//         $("#currentTime").val(gblServDateTime);
//         intDate = Date.parse(gblServDateTime);
    }

    function Start(updateCurrentTime){
        getTime();
        UpdateTimer();
	
        window.setInterval("UpdateTimer()", 1000);
    }

    function getDayName(dayCount){
        switch(dayCount){
            case 0:return "Sunday";
            case 1:return "Monday";
            case 2:return "Tuesday";
            case 3:return "Wednesday";
            case 4:return "Thursday";
            case 5:return "Friday";
            case 6:return "Saturday";
        }
    }

    function getFullNumber(number){
        if(number < 10)
            return '0' + number;
        else
            return number;
    }
</script>
<label id="lblTime" name="lblTime" class="omega1"></label>
<input type="hidden" name="currentTime" id="currentTime"/>