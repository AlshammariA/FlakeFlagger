@Test public void multiThreadedTimedBased() throws InterruptedException, IOException {
  setUpTimeBasedTriggeringPolicy(rfa);
  executeHarness(TOTAL_DURATION,false);
  printScriptForTimeBased();
  verify();
}
