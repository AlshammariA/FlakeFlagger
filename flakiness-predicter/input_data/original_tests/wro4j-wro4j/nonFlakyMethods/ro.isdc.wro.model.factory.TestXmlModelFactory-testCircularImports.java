@Test(expected=RecursiveGroupDefinitionException.class) public void testCircularImports(){
  loadModelFromLocation("testimport/circular1.xml");
}
