@Test(expected=WroRuntimeException.class) public void testInvalidImports(){
  loadModelFromLocation("testimport/invalidImports.xml");
}
