@Test(expected=WroRuntimeException.class) public void shouldDetectInvalidGroupReference(){
  final WroModel model=loadModelFromLocation("shouldDetectInvalidGroupReference.xml");
  assertTrue(model.getGroups().isEmpty());
}
