@Test(expected=WroRuntimeException.class) public void cannotCreateFromXmlWithInvalidNamespace(){
  loadModelFromLocation("invalidNamespace.xml");
}
