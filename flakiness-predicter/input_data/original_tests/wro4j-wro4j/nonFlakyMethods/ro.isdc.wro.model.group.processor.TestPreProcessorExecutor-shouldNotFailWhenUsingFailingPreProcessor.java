@Test public void shouldNotFailWhenUsingFailingPreProcessor() throws Exception {
  Context.get().getConfig().setIgnoreFailingProcessor(true);
  useFailingPreProcessor();
}
