@Test public void good() throws JoranException {
  simpleConfigurator.doConfigure(DEFINE_INPUT_DIR + GOOD_XML);
  InterpretationContext ic=simpleConfigurator.getInterpreter().getInterpretationContext();
  String inContextFoo=ic.getProperty("foo");
  assertEquals("monster",inContextFoo);
}
