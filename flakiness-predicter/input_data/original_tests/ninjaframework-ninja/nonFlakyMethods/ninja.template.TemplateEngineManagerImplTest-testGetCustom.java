@Test public void testGetCustom(){
  assertThat(createTemplateEngineManager(CustomTemplateEngine.class).getTemplateEngineForContentType("custom"),instanceOf(CustomTemplateEngine.class));
}
