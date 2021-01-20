<?php
`rm -rf /working/proj`;

$MAVEN_FLAGS="-Dmaven.test.failure.ignore=true -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Ddependency-check.skip=true -Dgpg.skip -Dmaven.javadoc.skip -Dandroid.sdk.path=/data/android -Dmaven.findbugsplugin.version=3.0.4 -fn -B";
$redis = new Redis();
$redis->connect(''); //Set to IP address of Redis server
$redis->auth(""); //Set to password for Redis server
$HOME_DIR = "/home/ubuntu"; // Set to home directory on the build worker
$TEMP_DIR = "/working"; //Set to a local directory writable on the build worker that can be used for running builds in
$SHARED_LOG_DIR = "/experiment/flaky-logs"; //Set to the shared directory to which you want the log files to be copied to

$job = $redis->lPop('build_queue');
$hostname = gethostbyname(trim(`hostname`));
if($job == ""){
	$redis->sAdd("idle",$hostname);
//	die("no more to do!");
	`sudo shutdown -h now`;
}

$job .= ",".$hostname;
$redis->sAdd("in_progress",$job);
$dat = explode(",",$job);
$proj = $dat[0];
$sha = $dat[1];
$idx = $dat[2];
$slug = str_replace("https://github.com/","",$proj);
$slug = str_replace("/","-", $slug);
$repoDir = "$HOME_DIR/repos/$slug";
$buildDir = "$TEMP_DIR/proj/$slug-$idx";
$logDir = "$buildDir/log";

@mkdir($logDir, 0755, true);
if(!file_exists($repoDir)){
	`git clone $proj $repoDir > $logDir/git.clone.base.log 2>&1`;
}

`git clone $repoDir $buildDir/$slug > $logDir/git.clone.log 2>&1`;
chdir($buildDir."/".$slug);
`git checkout $sha > $logDir/git.checkout.log 2>&1`;

`rm -rf $HOME_DIR/.m2`;
`timeout --kill-after=10s --signal=30 12h mvn $MAVEN_FLAGS install > $logDir/maven.log 2>&1`;

@mkdir($logDir."/tests/", 0755, true);
foreach(explode("\n",`find . -name surefire-reports`) as $dir)
{
	if($dir != "")
	{
		$tgt = str_replace("./","",$dir);
		$tgt = str_replace("target/","",$tgt);
		$tgt = str_replace("/","-",$tgt);
		`cp -r $dir $logDir/tests/$tgt`;
	}
}
foreach(explode("\n",`find . -name failsafe-reports`) as $dir)
{
    if($dir != "")
    {
        $tgt = str_replace("./","",$dir);
        $tgt = str_replace("target/","",$tgt);
        $tgt = str_replace("/","-",$tgt);
        `cp -r $dir $logDir/tests/$tgt`;
    }
}


`mv $logDir $SHARED_LOG_DIR/$slug-$idx`;
$redis->sRem("in_progress",$job);
$redis->lPush("done",$job);
`sudo reboot`;


?>
