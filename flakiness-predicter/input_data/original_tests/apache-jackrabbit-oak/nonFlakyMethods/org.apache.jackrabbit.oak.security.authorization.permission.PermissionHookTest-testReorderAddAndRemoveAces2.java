/** 
 * ACE    :  0   1   2   3   4   5   6   7 Before :  tp  ev  p0  p1  p2  p3 After  :      ev      p2  p1  p3  p4  p5
 */
@Test public void testReorderAddAndRemoveAces2() throws Exception {
  createPrincipals();
  AccessControlManager acMgr=getAccessControlManager(root);
  JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,testPath);
  for (int i=0; i < 4; i++) {
    acl.addAccessControlEntry(principals.get(i),privilegesFromNames(JCR_READ));
  }
  acMgr.setPolicy(testPath,acl);
  root.commit();
  AccessControlEntry[] aces=acl.getAccessControlEntries();
  acl.removeAccessControlEntry(aces[0]);
  acl.removeAccessControlEntry(aces[2]);
  acl.orderBefore(aces[4],aces[3]);
  acl.addAccessControlEntry(principals.get(4),privilegesFromNames(JCR_READ));
  acl.addAccessControlEntry(principals.get(5),privilegesFromNames(JCR_READ));
  acMgr.setPolicy(testPath,acl);
  root.commit();
  Tree entry=getEntry(principals.get(2).getName(),testPath,1);
  assertIndex(1,entry);
  entry=getEntry(principals.get(1).getName(),testPath,2);
  assertIndex(2,entry);
}
