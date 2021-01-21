@Test public void testInvalid(){
  try {
    new RestrictionDefinitionImpl(null,Type.BOOLEAN,false);
    fail("Creating RestrictionDefinition with null name should fail.");
  }
 catch (  NullPointerException e) {
  }
  try {
    new RestrictionDefinitionImpl(name,Type.UNDEFINED,false);
    fail("Creating RestrictionDefinition with undefined required type should fail.");
  }
 catch (  IllegalArgumentException e) {
  }
}
