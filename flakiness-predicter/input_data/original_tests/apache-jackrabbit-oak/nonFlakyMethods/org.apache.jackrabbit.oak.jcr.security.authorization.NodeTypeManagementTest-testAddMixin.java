@Test public void testAddMixin() throws Exception {
  modify(childNode.getPath(),Privilege.JCR_NODE_TYPE_MANAGEMENT,true);
  childNode.addMixin(mixinName);
  testSession.save();
}
