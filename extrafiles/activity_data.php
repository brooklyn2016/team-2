<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	$activity_id = $_GET['activity_id'];
	
	
	$check_name = mysqli_query($con,"SELECT * FROM activity where id = '$activity_id'");
	
	$product["success"] = false;

	
	while($row = mysqli_fetch_array($check_name)){
		$product = array();
		$product["activity"]["activity_number"] = $row["activity_number"];
		$product["activity"]["description"] = $row["description"];
		$product["activity"]["activity_objective"] = $row["activity_objective"];
		$product["activity"]["result"] = $row["result"];
		$product["activity"]["activity_time"] = $row["activity_time"];
		$product["activity"]["materials"] = $row["materials"];
		$product["activity"]["instruction"] = $row["inst"];
		// push single product into final response array
		$response["success"] = true;
	}
	mysqli_close($con);
	echo json_encode($product);
?>