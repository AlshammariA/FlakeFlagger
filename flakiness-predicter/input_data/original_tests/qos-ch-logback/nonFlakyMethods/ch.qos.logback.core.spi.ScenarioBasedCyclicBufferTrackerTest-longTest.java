@Test public void longTest(){
  parameters.simulationLength=100 * 1000;
  simulator=new CyclicBufferTrackerSimulator(parameters);
  simulator.buildScenario();
  simulator.simulate();
  verify();
}
