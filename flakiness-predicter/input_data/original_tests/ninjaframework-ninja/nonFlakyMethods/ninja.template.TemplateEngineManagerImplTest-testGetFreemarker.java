@Test public void testGetFreemarker(){
  assertThat(createTemplateEngineManager().getTemplateEngineForContentType(ContentTypes.TEXT_HTML),instanceOf(TemplateEngineFreemarker.class));
}
