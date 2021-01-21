@Test public void testInvalid(){
  try {
    new RestrictionImpl(null,false);
    fail("Creating RestrictionDefinition with null name should fail.");
  }
 catch (  NullPointerException e) {
  }
}
