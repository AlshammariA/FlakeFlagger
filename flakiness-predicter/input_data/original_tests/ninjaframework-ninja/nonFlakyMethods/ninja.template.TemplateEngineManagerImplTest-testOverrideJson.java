@Test public void testOverrideJson(){
  assertThat(createTemplateEngineManager(OverrideJsonTemplateEngine.class).getTemplateEngineForContentType(ContentTypes.APPLICATION_JSON),instanceOf(OverrideJsonTemplateEngine.class));
}
