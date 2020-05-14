<?php
$conn = mysqli_connect("192.168.200.169", "root", "0050", "CLA");
if (!$conn) {
    $error = mysqli_connect_error();
    $errno = mysqli_connect_errno();
    echo "$errno: $error\n";
    exit();
}
//mysqli_close($conn);

$query = "select * from Sensor;";
$result = mysqli_query($conn, $query);

if ( $result ) {
    echo "조회된 행의 수 : ".mysqli_num_rows($result)."<br />";

    while ($row = mysqli_fetch_assoc($result)) {
        printf ("%s : %s <br />", $row["place"], $row["value"]);
    }

    // 결과 해제
    mysqli_free_result($result);

} else {
    echo "Error : ".mysqli_error($db_conn);
}
 
?>
