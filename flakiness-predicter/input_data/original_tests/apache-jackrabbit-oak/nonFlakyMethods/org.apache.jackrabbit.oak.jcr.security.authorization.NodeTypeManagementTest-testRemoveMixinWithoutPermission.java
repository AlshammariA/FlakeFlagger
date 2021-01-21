@Test public void testRemoveMixinWithoutPermission() throws Exception {
  ((Node)superuser.getItem(childNode.getPath())).addMixin(mixinName);
  superuser.save();
  testSession.refresh(false);
  try {
    childNode.removeMixin(mixinName);
    testSession.save();
    fail("TestSession does not have sufficient privileges to remove a mixin type.");
  }
 catch (  AccessDeniedException e) {
  }
}
