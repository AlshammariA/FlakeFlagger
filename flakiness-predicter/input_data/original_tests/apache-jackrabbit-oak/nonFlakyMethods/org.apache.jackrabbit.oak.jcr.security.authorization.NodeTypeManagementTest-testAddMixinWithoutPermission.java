@Test public void testAddMixinWithoutPermission() throws Exception {
  try {
    childNode.addMixin(mixinName);
    testSession.save();
    fail("TestSession does not have sufficient privileges to add a mixin type.");
  }
 catch (  AccessDeniedException e) {
  }
}
