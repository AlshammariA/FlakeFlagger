@Test public void testCanAddMixin() throws Exception {
  assertFalse(childNode.canAddMixin(mixinName));
  modify(childNode.getPath(),Privilege.JCR_NODE_TYPE_MANAGEMENT,true);
  assertTrue(childNode.canAddMixin(mixinName));
  modify(childNode.getPath(),Privilege.JCR_NODE_TYPE_MANAGEMENT,false);
  assertFalse(childNode.canAddMixin(mixinName));
}
