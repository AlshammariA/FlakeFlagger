@Test public void testGetJson(){
  assertThat(createTemplateEngineManager().getTemplateEngineForContentType(ContentTypes.APPLICATION_JSON),instanceOf(TemplateEngineJson.class));
}
