@Test public void testSetPrimaryType() throws Exception {
  Node child=(Node)superuser.getItem(childNode.getPath());
  String ntName=child.getPrimaryNodeType().getName();
  String changedNtName="nt:folder";
  child.setPrimaryType(changedNtName);
  testSession.save();
  modify(childNode.getPath(),Privilege.JCR_NODE_TYPE_MANAGEMENT,true);
  childNode.setPrimaryType(ntName);
  testSession.save();
}
