@Test public void testRemoveMixin() throws Exception {
  ((Node)superuser.getItem(childNode.getPath())).addMixin(mixinName);
  superuser.save();
  testSession.refresh(false);
  modify(childNode.getPath(),Privilege.JCR_NODE_TYPE_MANAGEMENT,true);
  childNode.removeMixin(mixinName);
  testSession.save();
}
