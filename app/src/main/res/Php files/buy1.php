<?php
require "connect.php";
$sql ="select * from item where status='not sold';";
$result=mysqli_query($conn,$sql);
$response = array();	
while($row = mysqli_fetch_array($result)){
	
	$mysql_qry="select * from student where id like'$row[4]';";
	$result2 =mysqli_query($conn,$mysql_qry);
	//$sellerName=array();
	while($row2 = mysqli_fetch_array($result2)){
		$sellerName=array('fname' =>$row2[1] ,'lname'=>$row2[2] ,'year'=>$row2[4] ,'Class'=>$row2[5] ,'section'=>$row2[6] ,'mobile_no'=>$row2[8] ,'email'=>$row2[9] );
}
array_push($response,array("item_no"=>$row[0],"item_name"=>$row[1],"price"=>$row[2],"img"=>$row[3],"seller"=>$row[4],"description"=>$row[5],$sellerName));
//array_push($response,$sellerName);
}
echo json_encode(array("items"=>$response));
?>