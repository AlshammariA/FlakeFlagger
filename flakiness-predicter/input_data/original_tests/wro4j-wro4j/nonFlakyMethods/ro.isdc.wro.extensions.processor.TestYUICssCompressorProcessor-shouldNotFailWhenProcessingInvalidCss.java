@Test public void shouldNotFailWhenProcessingInvalidCss() throws Exception {
  victim.process(null,new StringReader("invalid CSS!!@#!@#!"),new StringWriter());
}
