@Test(expected=WroRuntimeException.class) public void shouldFailWhenUsingFailingPreProcessor() throws Exception {
  Context.get().getConfig().setIgnoreFailingProcessor(false);
  useFailingPreProcessor();
}
