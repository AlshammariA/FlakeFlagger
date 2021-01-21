@Test public void testGetNonExistingProducesNoNPE(){
  TemplateEngineManager manager=createTemplateEngineManager(OverrideJsonTemplateEngine.class);
  assertNull(manager.getTemplateEngineForContentType("non/existing"));
}
