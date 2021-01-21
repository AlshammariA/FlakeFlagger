@Test(expected=NullPointerException.class) public void cannotAcceptNullResourceTypeForIsEligible(){
  assertTrue(new ProcessorDecorator(new JSMinProcessor()).isEligible(true,null));
}
