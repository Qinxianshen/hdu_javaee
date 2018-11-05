<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

        <script language="javascript">  
            
        setInterval("timer.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);   
        localtime = new Date().getHours();  
        if(localtime >0 && localtime < 12)
        	{
        	setInterval("timer.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay()) + '上午好';",1000);
        	}
        else{
        	setInterval("timer.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay()) + '下午好';",1000);
        }
        </script>  
        
    </head>  
  
    <body>  
        <div id="timer"></div>  
		<div id="clienttime"></div>  
	</body>
</html>