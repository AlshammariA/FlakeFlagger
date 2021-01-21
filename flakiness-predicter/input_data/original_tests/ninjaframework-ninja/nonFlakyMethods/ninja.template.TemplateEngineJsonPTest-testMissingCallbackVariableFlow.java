@Test public void testMissingCallbackVariableFlow() throws IOException {
  TemplateEngineJsonP jsonpEngine=new TemplateEngineJsonP(logger,objectMapper,properties);
  jsonpEngine.invoke(context,result);
  String jsonp=new String(outputStream.toByteArray(),"UTF-8");
  assertEquals(TemplateEngineJsonP.DEFAULT_CALLBACK_PARAMETER_VALUE + "([123])",jsonp);
}
