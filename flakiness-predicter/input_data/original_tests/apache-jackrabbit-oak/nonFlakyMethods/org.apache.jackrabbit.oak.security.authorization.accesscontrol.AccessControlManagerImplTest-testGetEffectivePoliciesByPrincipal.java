@Test public void testGetEffectivePoliciesByPrincipal() throws Exception {
  Set<Set<Principal>> principalSets=new HashSet<Set<Principal>>();
  principalSets.add(Collections.singleton(getTestPrincipal()));
  principalSets.add(Collections.<Principal>singleton(EveryonePrincipal.getInstance()));
  principalSets.add(ImmutableSet.of(testPrincipal,EveryonePrincipal.getInstance()));
  for (  Set<Principal> principals : principalSets) {
    AccessControlPolicy[] policies=acMgr.getEffectivePolicies(principals);
    assertNotNull(policies);
    assertEquals(0,policies.length);
  }
  setupPolicy(testPath);
  for (  Set<Principal> principals : principalSets) {
    AccessControlPolicy[] policies=acMgr.getEffectivePolicies(principals);
    assertNotNull(policies);
    assertEquals(0,policies.length);
  }
  root.commit();
  for (  Set<Principal> principals : principalSets) {
    AccessControlPolicy[] policies=acMgr.getEffectivePolicies(principals);
    assertNotNull(policies);
    if (principals.contains(getTestPrincipal())) {
      assertEquals(1,policies.length);
    }
 else {
      assertEquals(0,policies.length);
    }
  }
  NodeUtil child=new NodeUtil(root.getTree(testPath)).addChild("child",JcrConstants.NT_UNSTRUCTURED);
  String childPath=child.getTree().getPath();
  setupPolicy(childPath);
  for (  Set<Principal> principals : principalSets) {
    AccessControlPolicy[] policies=acMgr.getEffectivePolicies(principals);
    assertNotNull(policies);
    if (principals.contains(getTestPrincipal())) {
      assertEquals(1,policies.length);
    }
 else {
      assertEquals(0,policies.length);
    }
  }
  root.commit();
  for (  Set<Principal> principals : principalSets) {
    AccessControlPolicy[] policies=acMgr.getEffectivePolicies(principals);
    assertNotNull(policies);
    if (principals.contains(getTestPrincipal())) {
      assertEquals(2,policies.length);
    }
 else {
      assertEquals(0,policies.length);
    }
  }
}
