@Test public void testGetEffectivePolicies() throws Exception {
  AccessControlPolicy[] policies=acMgr.getEffectivePolicies(testPath);
  assertNotNull(policies);
  assertEquals(0,policies.length);
  setupPolicy(testPath);
  root.commit();
  policies=acMgr.getEffectivePolicies(testPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  policies=acMgr.getEffectivePolicies(childPath);
  assertNotNull(policies);
  assertEquals(1,policies.length);
  setupPolicy(childPath);
  root.commit();
  policies=acMgr.getEffectivePolicies(childPath);
  assertNotNull(policies);
  assertEquals(2,policies.length);
}
