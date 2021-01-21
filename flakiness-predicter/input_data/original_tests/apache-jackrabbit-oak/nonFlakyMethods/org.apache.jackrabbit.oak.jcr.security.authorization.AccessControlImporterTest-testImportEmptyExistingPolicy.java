/** 
 * Imports an empty resource-based ACL for a policy that already exists.
 * @throws Exception
 */
public void testImportEmptyExistingPolicy() throws Exception {
  try {
    Node target=createImportTargetWithPolicy(null);
    doImport(target.getPath(),XML_POLICY_ONLY);
    AccessControlPolicy[] policies=superuser.getAccessControlManager().getPolicies(target.getPath());
    assertEquals(1,policies.length);
    assertTrue(policies[0] instanceof JackrabbitAccessControlList);
    AccessControlEntry[] entries=((JackrabbitAccessControlList)policies[0]).getAccessControlEntries();
    assertEquals(0,entries.length);
  }
  finally {
    superuser.refresh(false);
  }
}
