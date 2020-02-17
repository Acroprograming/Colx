<?php
require "connect.php";
$roll_number=$_POST['roll_number'];
$password=$_POST['password'];
$mysql_qry="select * from student where roll_number like'$roll_number' AND password like '$password';";
$result =mysqli_query($conn,$mysql_qry);
if(mysqli_num_rows($result)>0){
echo "login success\n";

while($row = mysqli_fetch_array($result)){
echo $row[0],"\n";
echo $row[1],"\n";
echo $row[2],"\n";
}
}
else{
echo "login not success";
}
?>
