<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	$response["modules"] = array("error" => true);
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	$module_id = $_GET['module_id'];
	
	
	$check_name = mysqli_query($con,"SELECT * FROM activity order by activity_number where module_id = '$module_id'");
	
	$response["success"] = false;
	//$response["modules"]  = array();

	
	while($row = mysqli_fetch_array($check_name)){
		$product = array();
		$product["activity_number"] = $row["activity_number"];
		$product["description"] = $row["description"];
		$product["activity_objective"] = $row["activity_objective"];
		$product["activity_time"] = $row["activity_time"];
		$product["materials"] = $row["materials"];
		$product["instruction"] = $row["instruction"];
		// push single product into final response array
		array_push($response["modules"], $product);
		$response["success"] = true;
	}
	//echo json_encode($rows);
	mysqli_close($con);
	echo json_encode($response);
?>