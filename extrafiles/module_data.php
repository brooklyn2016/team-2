<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	
	
	$check_name = mysqli_query($con,"SELECT * FROM module");
	
	$product["success"] = false;
	$response["module"]  = array();

	
	while($row = mysqli_fetch_array($check_name)){
		$product = array();
		$product["module_id"] = $row["id"];
		$product["module_name"] = $row["module_name"];
		$product["module_time"] = $row["module_time"];
		$product["num_of_activities"] = $row["num_of_activities"];
		$product["materials"] = $row["materials"];
		$product["objective"] = $row["objective"];
		$product["content"] = $row["c0nt3"];
		$product["module_number"] = $row["module_number"];
		// push single product into final response array
		array_push($response["module"], $product);
		$response["success"] = true;
	}
	//echo json_encode($rows);
	mysqli_close($con);
	echo json_encode($response);
?>