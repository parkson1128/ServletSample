<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>JSP測試</title>
</head>
<body>
JSP JSP JSp JSP JSP JSP


<script>
		var value= "112233445566";
		console.log("JSP value=" + value);
        $.ajax({
            url:'ReadFile',
            type:'POST',
            data:{value : value},           
            success : function(data){
                //alert('success');
                console.log("ReadFile-ajax-success");
                console.log("ReadFile-test0222");
                console.log("servlet回傳=\n" + data);
      	 	 }
      	  });
		
/*        $.ajax({
             url:'HelloWorld0519',
             type:'POST',
             data:{value : value},           
             success : function(data){
                 //alert('success');
                 console.log("ajax-success");
                 console.log("test0222");
                 console.log("servlet回傳=\n" + data);
                 
	
//                  <table border="1" width="303">
//                  <tr>
//                  <td width="119"><b>User ID</b></td>
//                  <td width="168"><b>User Name</b></td>
//                  </tr>
                 
//                  //List data= (List)request.getAttribute("data");
//                  for (itr=data.iterator(); itr.hasNext(); )
//                  {
//                      <tr>
// 	                 <td width="119"></td>
// 	                 <td width="168"></td>
// 	                 </tr>
//                  }
                 
//                  </table>
		
                 
             }
           });
           
*/

           </script>
</body>
</html>