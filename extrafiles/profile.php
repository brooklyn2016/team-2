<?php
	$con=mysqli_connect("localhost","mrahman_user","p@ssw0rd","mrahman_data");
	
	$response["profile_info"] = array(); // will hold return value
	//if we cannot connect, send an error
	if (mysqli_connect_errno($con))
	{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	//get id which will be used to provide info
	$profile_id = $_GET['profile_id'];
	
	//will be used to collect data
	$check_name = mysqli_query($con,"SELECT * FROM profile_info where profile_uid = '$profile_id'");// where college_id = '$college_id'");
	
	$response["success"] = false;

	//traverse check_name for data
	if($row = mysqli_fetch_array($check_name)){
		//store data in an array within response
		$response["profile_info"]["points"] = $row["profile_points"];
		$response["profile_info"]["comptasks"] = $row["profile_comptasks"];
		$response["error"] = false;		
		$response["success"] = true;
		
	}
	else{
		//create new values if it is a newly instantiated account
		$sql = "INSERT INTO mrahman_data.profile_info (profile_uid, profile_points, profile_comptasks) VALUES ('$profile_id', 0, 0)";
		$result = mysqli_query($con,$sql);
		$response["profile_info"]["points"] = 0;
		$response["profile_info"]["comptasks"] = 0;
		$response["error"] = false;		
		$response["success"] = true;
	}
	mysqli_close($con);
	echo json_encode($response);
?>