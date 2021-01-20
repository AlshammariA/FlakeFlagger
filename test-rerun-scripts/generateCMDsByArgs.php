<?php
$redis = new Redis();
$redis->connect(''); //Set to IP address of Redis server
$redis->auth(""); //Set to password for Redis server
//$redis->del("build_queue");
//$redis->del("in_progress");
//$redis->del("done");
$count = $argv[2];
$proj = $argv[1];
print "Generate: $count for $proj\n";

$start = 10000;

for($i = $start; $i<$count+$start; $i++){
	$redis->rPush("build_queue",$proj.",$i");
}
?>
