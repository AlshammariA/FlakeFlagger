@Test(expected=RecursiveGroupDefinitionException.class) public void testRecursiveImports(){
  loadModelFromLocation("testimport/recursive.xml");
}
