@Test public void testGetJsonP(){
  assertThat(createTemplateEngineManager().getTemplateEngineForContentType(ContentTypes.APPLICATION_JSONP),instanceOf(TemplateEngineJsonP.class));
}
