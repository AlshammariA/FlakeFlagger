@Test public void testOverrideHtml(){
  assertThat(createTemplateEngineManager(OverrideHtmlTemplateEngine.class).getTemplateEngineForContentType(ContentTypes.TEXT_HTML),instanceOf(OverrideHtmlTemplateEngine.class));
}
