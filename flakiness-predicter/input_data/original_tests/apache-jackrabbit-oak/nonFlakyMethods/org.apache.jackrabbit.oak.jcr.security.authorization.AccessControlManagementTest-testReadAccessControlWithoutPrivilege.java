@Test public void testReadAccessControlWithoutPrivilege() throws Exception {
  Privilege[] privileges=privilegesFromName(Privilege.JCR_READ);
  JackrabbitAccessControlList tmpl=allow(path,privileges);
  String policyPath=tmpl.getPath() + "/rep:policy";
  assertTrue(superuser.itemExists(policyPath));
  assertFalse(testAcMgr.hasPrivileges(path,privilegesFromName(Privilege.JCR_READ_ACCESS_CONTROL)));
  assertFalse(testSession.itemExists(policyPath));
  assertFalse(testSession.nodeExists(policyPath));
  try {
    testSession.getNode(policyPath);
    fail("Accessing the rep:policy node must throw PathNotFoundException.");
  }
 catch (  PathNotFoundException e) {
  }
  try {
    testAcMgr.getPolicies(tmpl.getPath());
    fail("test user must not have READ_AC privilege.");
  }
 catch (  AccessDeniedException e) {
  }
  try {
    testAcMgr.getEffectivePolicies(tmpl.getPath());
    fail("test user must not have READ_AC privilege.");
  }
 catch (  AccessDeniedException e) {
  }
  for (NodeIterator aceNodes=superuser.getNode(policyPath).getNodes(); aceNodes.hasNext(); ) {
    Node aceNode=aceNodes.nextNode();
    String aceNodePath=aceNode.getPath();
    assertFalse(testSession.nodeExists(aceNodePath));
    for (PropertyIterator it=aceNode.getProperties(); it.hasNext(); ) {
      assertFalse(testSession.propertyExists(it.nextProperty().getPath()));
    }
  }
}
