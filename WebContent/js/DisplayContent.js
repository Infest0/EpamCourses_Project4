function PageRecive(s)
{
    document.getElementById('body').innerHTML = s;
}
 
var xmlHttp=false;

function AjaxCreate() {
    if (xmlHttp) return true;
    
    /*For IE5 and lower */
    
    /*@cc_on @*/
    /*@if (@_jscript_version >= 5)
    try {
        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e2) {
            xmlHttp = false;
        }
    }
    @end @*/
    
    if (!xmlHttp && typeof XMLHttpRequest != 'undefined')
        xmlHttp = new XMLHttpRequest();
    if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
        d.write('<div style="font-size: 16pt; color: black;">AJAX INTERNAL ERROR. MAYBE JS IS NOT ALLOWED.</div>');
        xmlHttp=false;
        return false;
    }
    
    return true;
}
 
function AjaxGet(url, callback, commandParameter) {
	
    function UpdatePage()
    {
        if (xmlHttp.readyState == 4) {
            callback(xmlHttp.responseText);
        }
    }
    
    additionQuery = "";
	
	for(var i=3; i<arguments.length; i++) { 
		additionQuery+= '&';
		value = $("#"+arguments[i]).val();
		additionQuery+= (arguments[i]+'='+value);

	}
	
    if (!xmlHttp) AjaxCreate();
    xmlHttp.open('GET', url + "command=" + commandParameter + additionQuery, true);
    xmlHttp.onreadystatechange = UpdatePage;
    xmlHttp.send(null);
}

function setChosen(idChoose, idOut) {
	value = $("#"+idChoose).val();
	$("#"+idOut).val(value);
}

 