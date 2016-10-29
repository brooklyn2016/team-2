<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	$response["quiz"] = array();
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	$activity_id = $_GET['activity_id'];
	
	
	$check_name = mysqli_query($con,"SELECT * FROM quiz where id = '$activity_id'");
	
	$response["success"] = false;
	//$response["colleges"]  = array();

	
	while($row = mysqli_fetch_array($check_name)){
		$product = array();
		$product["quiz_question"] = $row["quiz_question"];
		$product["answers"]["answer1"] = $row["answer1"];
		$product["answers"]["answer2"] = $row["answer2"];
		$product["answers"]["answer3"] = $row["answer3"];
		$product["answers"]["answer4"] = $row["answer4"];
		$product["right_answer"] = $row["right_answer"];
		//$product["activity_id"] = $row["activity_id"];
		// push single product into final response array
		array_push($response["activity"], $product);
		$response["success"] = true;
	}
	//echo json_encode($rows);
	mysqli_close($con);
	echo json_encode($response);
?>