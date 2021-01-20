<?php
ini_set('memory_limit', '8G');
$projs = [];
$dir = "/experiment/logs/logs";
foreach (glob("$dir/$argv[1]/*") as $runInfo) {
    if (preg_match('/(.*)\/(\d+)/', $runInfo, $m)) {
        $proj = $m[1];
        $proj = str_replace("$dir/", "", $m[1]);
        $idx = $m[2];
        if (!isset($projs[$proj]))
            $projs[$proj] = [];
        $projs[$proj][] = $runInfo;
    }
}
print "Project,Test,IsFlaky,NumFailingRuns,NumPassingRuns,ExampleFailingRun,ExamplePassingRun\n";
foreach ($projs as $proj => $idxs) {
    $tests = [];
    foreach ($idxs as $runInfo) {
		preg_match('/(.*)\/(\d+)/', $runInfo, $m);
		$idx = $m[2];

        if (!isset($tests[$proj]))
            $tests[$proj] = [];

		`tar -C /tmp -xzf $runInfo`;
		$classCount = 0;
        foreach (explode("\n", `find /tmp/$proj-$idx -name "*.xml"`) as $f) {
            if ($f != "") {
				$classCount++;
                $d = simplexml_load_file($f);
                for ($i = 0; $i < count($d->testcase); $i++) {
                    $name = $d->testcase[$i]->attributes()['name']->__toString();
                    $fullName = $d->testcase[$i]->attributes()['classname']->__toString();
                    $fullName .= "#" . $name;
					$fullName = str_replace(",",";",$fullName);
                    $failed = false;
                    if (!isset($tests[$proj][$fullName])) {
                        $tests[$proj][$fullName] = ["failure" => [], "success" => []];
                    }
                    if (isset($d->testcase[$i]->failure) || isset($d->testcase[$i]->error)) {
                        $tests[$proj][$fullName]['failure'][] = $idx;
                    } else
                        $tests[$proj][$fullName]['success'][] = $idx;
                }
            }
        }
		if($classCount < 25)
			print "$idx\t$classCount\n";
		`rm -rf /tmp/$proj-$idx`;
    }
    foreach ($tests as $project => $projData) {
        foreach ($projData as $testName => $r) {
            $examplePass = -1;
			$nSuccess = count($r['success']);
			$nFail = count($r['failure']);
            if ($nSuccess > 0)
                $examplePass = array_shift($r['success']);
            $exampleFail = -1;
            if ($nFail > 0)
                $exampleFail = array_shift($r['failure']);

			$flaky = 0;
			if($exampleFail >=0 && $examplePass >= 0)
				$flaky =1;
            print "$project,$testName,$flaky," . $nFail.  "," . $nSuccess. ",$exampleFail,$examplePass\n";
        }
    }
}

?>
