@Test public void testAccessControlModificationWithoutPrivilege() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_MODIFY_PROPERTIES});
  JackrabbitAccessControlList tmpl=allow(path,privileges);
  String policyPath=tmpl.getPath() + "/rep:policy";
  assertTrue(superuser.itemExists(policyPath));
  try {
    testAcMgr.setPolicy(tmpl.getPath(),tmpl);
    fail("test user must not have MODIFY_AC privilege.");
  }
 catch (  AccessDeniedException e) {
  }
  try {
    testAcMgr.removePolicy(tmpl.getPath(),tmpl);
    fail("test user must not have MODIFY_AC privilege.");
  }
 catch (  AccessDeniedException e) {
  }
}
