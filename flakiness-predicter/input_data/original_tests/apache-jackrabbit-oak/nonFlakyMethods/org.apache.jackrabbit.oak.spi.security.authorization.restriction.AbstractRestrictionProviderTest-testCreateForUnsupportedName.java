@Test public void testCreateForUnsupportedName() throws Exception {
  try {
    restrictionProvider.createRestriction(unsupportedPath,"unsupported",globValue);
    fail();
  }
 catch (  AccessControlException e) {
  }
  try {
    restrictionProvider.createRestriction(unsupportedPath,"unsupported",nameValues);
    fail();
  }
 catch (  AccessControlException e) {
  }
}
