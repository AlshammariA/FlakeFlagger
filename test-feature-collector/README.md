# test-feature-collector

This is a test smell and other behavioral feature detection framework. 
It integrates with Maven to make it "easy" to integrate with off-the-shelf Maven projects for the purpose of running evaluations.
It automatically installs [JaCoCo](https://www.eclemma.org/jacoco/) to a project's test running configuration to collect per-test statement coverage.
Then, it provides a series of detectors and reporters that analyze that coverage data in conjunction with a complete AST of all of the code that is executed, automatically constructed by the [Eclipse JDT](https://www.eclipse.org/jdt/) library.


Installing to use on real projects
----
`mvn install` at the top-level of this project (this directory), then copy `maven-extension/target/test-smells-maven-extension-1.0-SNAPSHOT.jar` to your `$MAVEN_DIRECTORY/lib/ext` directory. This will make the test smell detector active on every Maven run (you will not need to add extra flags or change any `pom.xml`). You might find it makes the most sense to make a new copy of Maven and install the test smell detector in that other Maven... then when you want the smell detector to run, use that other Maven.

Collecting the output
----
Once you have installed the detection framework, it will collect both static and dynamic features for each test when it runs. 
The two requirements for running it on a project are:
1. The project must use the Maven build system
1. The project must be in a git repository. If your `pom.xml` is at the root of your repository, the plugin will automatically find the `.git` folder. Otherwise, set the environmental variable `gitDir` to the location of the `.git` folder for this project.

To run all of a project's tests, use the version of Maven that you've installed the `test-smells-maven-extension` to, and run `mvn verify` (`mvn test` will run all 'unit' tests, and `verify` will also run integration tests, if they exist for that project). The plugin that generates these reports will do so per-module for a multi-module project (resulting in multiple output files). For each Maven `$OUTPUTDIR` (e.g. `target` directory) for each module with tests, the reporter will create the following files:
* `smells.csv` A CSV file of format `project,testClassName,testMethodName,smell` that contains one row for each smell detected on each test method
* `smells-pretty.csv` A rotated version of `smells.csv`, where each test method is represented by a single row, with a column for each test smell that was checked for, entries of `0` to indicate that this test did not present the smell, or `1` to show that it did
* `demographic-reports/ExecutionTime.csv` A CSV file of format `project,testClassName,testMethodName,ExecutionTime`, recording the execution time of each test method (as reported by Maven's test runner), measured in seconds
* `demographic-reports/LibrariesUsage.csv` A CSV file of format `project,testClassName,testMethodName,libraryName` that includes the list of API libraries called by each test. This file reports *every* class `C` that is the owner of each method `m` that is invoked by each test.
* `demographic-reports/basicDemographics.csv` A CSV file of format `project,testClassName,testMethodName,testLength,numAsserts,numCoveredLines` that includes basic demographics captured from examining each test method: the number of lines of code in that test method, the number of assertions in that test method, and the number of lines covered by that test method.
* `demographic-reports/churn.csv` A CSV file of format `project,test,projectSourceLinesCovered,projectSourceClassesCovered,avgModificationsPerCoveredLine_window5,maxModificationsPerCoveredLine_window5,hIndexModificationsPerCoveredLine_window5,avgAuthorsPerCoveredLine_window5,maxAuthorsPerCoveredLine_window5,percentOfModificationsCoveredByTest_window5` (with the same statistics calculated for window sizes 10, 25, 50, 75, 100, 500, 10,000). The statistics are calculated as follows:
    * `avgModificationsPerCoveredLine_window{N}` The ratio of (number of lines modified in the past `N` commits that were covered by this test) to all lines covered by this test
    * `maxModificationsPerCoveredLine_window{N}` For each of the lines covered by this test, compute the number of times each line was modified in the past `N` commits, and report the maximum
    * `hIndexModificationsPerCoveredLine_window{N}` For each of the lines covered by this test, compute the maximum value `H` such that at least `H` lines covered by this test were modified at least `H` times in the past `N` commits.
    * `avgAuthorsPerCoveredLine_window{N}` For each of the lines covered by this test, and each of the past `N` commits in this repo, the average number of authors (as reported by unique email addresses in git) of the commits touching those lines
    * `maxAuthorsPerCoveredLine_window{N}` For each of the lines covered by this test, and each of the past `N` commits in this repo, calculate the number of authors who touched each of those covered lines, and report the maximum
    * `percentOfModificationsCoveredByTest_window{N}` For each of the lines changed in the past `N` commits, report the percentage of those changed lines that are covered by this test
* `demographic-reports/testMethods/<testClassName>.<testMethodName>.testMethod` The body of each test method extracted into its own file, used for downstream processing by vocabulary-based flaky test detection approaches.

Writing new smell detectors
------
This platform can be useful for collecting new metrics about test execution - it provides a unified interface to examine per-test code coverage data in the context of the source and library code of that test.
Test smell detectors are classes that extend `edu.gmu.swe.smells.detector.AbstractTestSmellDetector`. The detector is called once for every test method in the project. The `TestContext` object exposes the test name, and also the list of statements that are executed by the test. Each statement is a JDT object, and you should inspect it by using a visitor (see `edu.gmu.swe.smells.detector.CallsSleepSmellDetector` for an example).

