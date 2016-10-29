<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	$response["activity"] = array();
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	

	$module_id = $_GET['module_id'];
	
	$check_name = mysqli_query($con,"SELECT * FROM activity where module_id = '$module_id'");
	
	$response["success"] = false;

	
	while($row = mysqli_fetch_array($check_name)){
		$product = array();
		$product["activity_number"] = $row["activity_number"];
		$product["description"] = $row["description"];
		$product["activity_objective"] = $row["activity_objective"];
		$product["result"] = $row["result"];
		$product["activity_time"] = $row["activity_time"];
		$product["materials"] = $row["materials"];
		$product["instruction"] = $row["inst"];
		// push single product into final response array
		array_push($response["activity"], $product);
		$response["success"] = true;
	}
	mysqli_close($con);
	echo json_encode($response);
?>