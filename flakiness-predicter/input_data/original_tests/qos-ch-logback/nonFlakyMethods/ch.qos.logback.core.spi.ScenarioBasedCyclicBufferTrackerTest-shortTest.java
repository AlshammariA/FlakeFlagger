@Test public void shortTest(){
  parameters.keySpaceLen=64;
  parameters.maxTimestampInc=500;
  parameters.simulationLength=70;
  simulator=new CyclicBufferTrackerSimulator(parameters);
  simulator.buildScenario();
  simulator.simulate();
  verify();
}
