@Test public void testValidImports(){
  final WroModel model=loadModelFromLocation("testimport/validImports.xml");
  assertEquals(2,new WroModelInspector(model).getGroupNames().size());
  LOG.debug("model: " + model);
}
