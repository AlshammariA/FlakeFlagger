@Test public void should_have_symmetric_equals(){
  assertEqualsIsSymmetric(factory,new BasicErrorMessageFactory("Hello %s","Yoda"));
}
