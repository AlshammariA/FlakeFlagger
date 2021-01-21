@Test public void testSetOrderableChildrenSetsProperty() throws Exception {
  Tree tree=root.getTree("/").addChild("test");
  tree.setOrderableChildren(true);
  assertTrue(((MutableTree)tree).getNodeState().hasProperty(TreeConstants.OAK_CHILD_ORDER));
  tree.setOrderableChildren(false);
  assertFalse(((MutableTree)tree).getNodeState().hasProperty(TreeConstants.OAK_CHILD_ORDER));
  tree.setOrderableChildren(true);
  root.commit();
  assertTrue(((MutableTree)tree).getNodeState().hasProperty(TreeConstants.OAK_CHILD_ORDER));
  tree.setOrderableChildren(false);
  root.commit();
  assertFalse(((MutableTree)tree).getNodeState().hasProperty(TreeConstants.OAK_CHILD_ORDER));
}
