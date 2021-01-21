/** 
 * Creating a tree which is referenceable doesn't require any property related privilege to be granted as the jcr:uuid property is defined to be autocreated and protected.
 */
@Test public void testCreateJcrUuid() throws Exception {
  setupPermission("/a",testPrincipal,true,PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_ADD_CHILD_NODES);
  Root testRoot=getTestRoot();
  testRoot.refresh();
  NodeUtil a=new NodeUtil(testRoot.getTree("/a"));
  NodeUtil test=a.addChild("referenceable2",NT_NAME);
  test.setString(JcrConstants.JCR_UUID,IdentifierManager.generateUUID());
  testRoot.commit();
}
