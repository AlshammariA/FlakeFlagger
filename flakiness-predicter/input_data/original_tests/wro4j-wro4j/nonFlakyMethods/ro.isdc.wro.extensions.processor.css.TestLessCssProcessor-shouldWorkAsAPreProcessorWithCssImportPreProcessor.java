@Test public void shouldWorkAsAPreProcessorWithCssImportPreProcessor() throws Exception {
  final BaseWroManagerFactory managerFactory=new BaseWroManagerFactory();
  managerFactory.setProcessorsFactory(new SimpleProcessorsFactory().addPreProcessor(new CssImportPreProcessor()).addPreProcessor(new LessCssProcessor()));
  final Injector injector=InjectorBuilder.create(managerFactory).build();
  final PreProcessorExecutor preProcessorExecutor=new PreProcessorExecutor();
  injector.inject(preProcessorExecutor);
  final List<Resource> resources=new ArrayList<Resource>();
  final String baseFolder="ro/isdc/wro/extensions/processor/lesscss";
  resources.add(Resource.create(String.format("classpath:%s/test/import.css",baseFolder)));
  final String noImports=preProcessorExecutor.processAndMerge(resources,ProcessingCriteria.create(ProcessingType.IMPORT_ONLY,true));
  final StringWriter actual=new StringWriter();
  victim=new LessCssProcessor();
  WroTestUtils.createInjector().inject(victim);
  victim.process(null,new StringReader(noImports),actual);
  final String expected=IOUtils.toString(managerFactory.create().getUriLocatorFactory().locate(String.format("classpath:%s/expected/import.cssx",baseFolder)));
  assertEquals(expected,actual.toString());
}
