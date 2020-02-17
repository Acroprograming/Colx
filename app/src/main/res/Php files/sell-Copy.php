<?php
require "connect.php";
$item_name=$_POST['item_name'];
$description=$_POST['description'];
$id=$_POST['id'];
$price=$_POST['price'];
$img=$_POST['img'];
$img_name=$item_name.strval($id);
$ip=$_POST['ip'];
/*#$name=$_FILES['img']['name'];
#$text_after_split=explode('.',$name);
#$file_ext=strtolower(end($text_after_split));
$file_tmp=$_FILES['img']['tmp_name'];*/
$path = "img/$img_name."."png";
	
$actualpath ="http://".$ip."/colx/".$path ;

if(!empty($_POST['item_name']) && !empty($_POST['description']) && !empty($_POST['id']) && !empty($_POST['img']) && !empty($_POST['ip']) ) {
$mysql_qry="INSERT INTO `item` (`item_name`, `price`, `img`, `seller`, `description`, `status`, `buyer`) VALUES('$item_name',$price, '$actualpath',$id, '$description','not sold',NULL);";
if(mysqli_query($conn,$mysql_qry)){
    file_put_contents($path,base64_decode($img));
    echo "successfully added for sale";
}
else
{
echo "failed to sell item";
}}
else{
echo "failed to sell the item";
}
?>