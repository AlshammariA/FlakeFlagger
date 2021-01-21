/** 
 * This test should work when running at least on dual-core. It assumes that (P1(r1) + P2(r1) + P3(r1)) + (P1(r2) + P2(r2) + P3(r2)) > Parallel(P1(r1) + P2(r1) + P3(r1) | P1(r2) + P2(r2) + P3(r2))
 */
@Test public void preProcessingInParallelIsFaster() throws Exception {
  final int availableProcessors=Runtime.getRuntime().availableProcessors();
  LOG.info("availableProcessors: {}",availableProcessors);
  if (availableProcessors > 1) {
    final StopWatch watch=new StopWatch();
    final WroConfiguration config=Context.get().getConfig();
    initExecutor(createSlowPreProcessor(100),createSlowPreProcessor(100),createSlowPreProcessor(100));
    final List<Resource> resources=createResources(Resource.create("r1",ResourceType.JS),Resource.create("r2",ResourceType.JS));
    config.setParallelPreprocessing(true);
    victim.processAndMerge(resources,true);
    watch.start("parallel preProcessing");
    config.setParallelPreprocessing(true);
    victim.processAndMerge(resources,true);
    watch.stop();
    final long parallelExecution=watch.getLastTaskTimeMillis();
    config.setParallelPreprocessing(false);
    watch.start("sequential preProcessing");
    victim.processAndMerge(resources,true);
    watch.stop();
    final long sequentialExecution=watch.getLastTaskTimeMillis();
    final String message="Processing details: \n" + watch.prettyPrint();
    LOG.debug(message);
    final double delta=parallelExecution * 0.8;
    Assert.assertTrue(String.format("%s  > %s + %s",sequentialExecution,parallelExecution,delta),sequentialExecution > parallelExecution + delta);
  }
}
