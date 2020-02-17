<?php
require "connect.php";
$fname=$_POST['fname'];
$lname=$_POST['lname'];
$year=$_POST['year'];
$roll_number=$_POST['roll_number'];
$Class=$_POST['Class'];
$email=$_POST['email'];
$section=$_POST['section'];
$password=$_POST['password'];
$mobile_number=$_POST['mobile_number'];
if(!empty($_POST['fname']) && !empty($_POST['lname']) && !empty($_POST['year']) && !empty($_POST['roll_number']) && !empty($_POST['Class']) && !empty($_POST['section']) && !empty($_POST['mobile_number']) && !empty($_POST['password']) && strlen($mobile_number)==10){
$mysql_qry="INSERT INTO student (fname, lname, roll_number, Year, class, section, password, mobile_no, email) VALUES ('$fname','$lname','$roll_number','$year','$Class','$section','$password','$mobile_number','$email')";
if(mysqli_query($conn,$mysql_qry) or die(mysqli_error($conn))){
echo "registration success";
}
else{
echo "registration not success";
}}
else{
echo "registration not success";
}

?>