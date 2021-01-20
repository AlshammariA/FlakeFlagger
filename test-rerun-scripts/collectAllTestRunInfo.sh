#!/bin/bash
echo "Project,Test,IsFlaky,NumFailingRuns,NumPassingRuns,ExampleFailingRun,ExamplePassingRun\n" > test_results.csv
find ../flaky-by-project10k -type f -name 'stdout' -exec tail -q -n+2 {} + >> test_results.csv
