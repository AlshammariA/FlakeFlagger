@Test public void mediumTest(){
  parameters.simulationLength=20000;
  simulator=new CyclicBufferTrackerSimulator(parameters);
  simulator.buildScenario();
  simulator.simulate();
  verify();
}
