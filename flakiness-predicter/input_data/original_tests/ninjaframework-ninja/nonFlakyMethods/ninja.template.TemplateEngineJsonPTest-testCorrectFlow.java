@Test public void testCorrectFlow() throws IOException {
  when(context.getParameter("callback",TemplateEngineJsonP.DEFAULT_CALLBACK_PARAMETER_VALUE)).thenReturn("App.callback");
  TemplateEngineJsonP jsonpEngine=new TemplateEngineJsonP(logger,objectMapper,properties);
  jsonpEngine.invoke(context,result);
  String jsonp=new String(outputStream.toByteArray(),"UTF-8");
  assertEquals("App.callback([123])",jsonp);
}
