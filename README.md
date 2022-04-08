# FlakeFlagger
 [![pipeline status](https://gitlab.com/neu-se/flakeflagger/badges/main/pipeline.svg)](https://gitlab.com/neu-se/flakeflagger/-/commits/main)

 
This repository is linked to our paper "FlakeFlagger: Predicting Flakiness Without Rerunning Tests". The preprint of the paper is avaiable in this [link](https://www.jonbell.net/preprint/icse21-flakeflagger.pdf). 
Authors: Abdulrahman Alshammari, Christopher Morris, Michael Hilton, Jonathan Bell
## Step 0: Identifying Flaky Tests through Reruns
The first part of experimental process is to generate a dataset of flaky tests by rerunning the test suite of each project in our
study set 10,000 times. We ran this experiment set up in a simple cluster, where one machine was designated as the 
leader, which shared a mountpoint using NFS with the rest of the cluster (coded as `/experiment/` in the attached scripts), and also ran a Redis queue. All other machines in the cluster were
configured to execute the script `runOneBuild.php` upon boot. This script polls the Redis queue for a build job to perform, runs the build,
saves the results, and reboots the machine when done. The `generateCMDsByArgs.php` script populates that build queue with projects to build.
These scripts are in the `test-rerun-scripts` directory of this repository.
The results of our rerun experiment are in `test-rerun-scripts/test_results.csv`.

Running this experiment requires non-trivial resources and general cloud computing expertise.
We expect that what might be *most* useful for other researchers is the rich dataset that we collected from this experiment - which includes
not only the outcomes of each test run (pass/fail), but also the console output and execution time of each test.

All results from this experiment are permanently [archived in Zenodo](https://zenodo.org/record/4450723#.YAhKgi1h1GQ). Once
this artifact completes the artifact review process, we will add the entire contents of this GitHub repository to that Zenodo archive,
creating a final version of our artifact that will be permanently archived and available.

## Step 1: Feature Collection
We created a Maven build extension that automates the process of collecting the various static and dynamic features of each test case
that we use in our predictive model. This tooling, including a detailed readme are located in the `test-feature-collector` directory.


## Step 2: Flakiness Prediction 
We used the machine learning concepts to learn and predict flaky tests. This part is a classification problem and it is well explained with a readme file in the `flakiness-predicter` directory.

## Dataset notes for static analysis
As described [in our ICSE 2021 paper](https://www.jonbell.net/preprint/icse21-flakeflagger.pdf), the tests in our dataset were gathered by inspecting the logs reported by maven of which tests were executed. Static approaches that aim to analyze the method bodies of these tests may fail to locate tests, for example because they are written in another language (like Groovy) or are dynamically instantiated (using a parameterized or custom runner, or through inheritance). As [others have reported](https://github.com/AlshammariA/FlakeFlagger/pull/4), there are 453 tests in our dataset that can not be easily extracted statically.  
