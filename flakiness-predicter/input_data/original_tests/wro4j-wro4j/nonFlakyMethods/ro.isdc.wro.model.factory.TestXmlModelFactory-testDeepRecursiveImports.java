@Test(expected=RecursiveGroupDefinitionException.class) public void testDeepRecursiveImports(){
  loadModelFromLocation("testimport/deepRecursive.xml");
}
