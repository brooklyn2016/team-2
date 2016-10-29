<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	$response["profile_info"] = array();
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	$profile_id = $_GET['profile_id'];
	
	
	$check_name = mysqli_query($con,"SELECT * FROM profile_info where profile_uid = '$profile_id'");// where college_id = '$college_id'");
	
	$response["success"] = false;

	
	if($row = mysqli_fetch_array($check_name)){

		$response["profile_info"]["points"] = $row["profile_points"];
		$response["profile_info"]["comptasks"] = $row["profile_comptasks"];
		$response["error"] = false;		
		$response["success"] = true;
		
	}
	else{
		$sql = "INSERT INTO mrahman_data.profile_info (profile_uid, profile_points, profile_comptasks) VALUES ('$profile_id', 0, 0)";
		$result = mysqli_query($con,$sql);
		$response["profile_info"]["points"] = 0;
		$response["profile_info"]["comptasks"] = 0;
		$response["error"] = false;		
		$response["success"] = true;
	}
	//echo json_encode($rows);
	mysqli_close($con);
	echo json_encode($response);
?>