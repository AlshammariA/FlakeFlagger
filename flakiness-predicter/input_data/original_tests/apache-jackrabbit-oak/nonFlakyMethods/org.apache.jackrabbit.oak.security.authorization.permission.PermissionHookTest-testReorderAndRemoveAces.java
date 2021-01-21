/** 
 * ACE    :  0   1   2   3   4   5   6   7 Before :  tp  ev  p0  p1  p2  p3 After  :      p1      ev  p3  p2
 */
@Test public void testReorderAndRemoveAces() throws Exception {
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
  acl.orderBefore(aces[4],null);
  acl.orderBefore(aces[3],aces[1]);
  acMgr.setPolicy(testPath,acl);
  root.commit();
  Tree entry=getEntry(EveryonePrincipal.NAME,testPath,1);
  assertIndex(1,entry);
  entry=getEntry(principals.get(2).getName(),testPath,3);
  assertIndex(3,entry);
  for (  String pName : new String[]{testPrincipalName,principals.get(0).getName()}) {
    try {
      getEntry(pName,testPath,0);
      fail();
    }
 catch (    RepositoryException e) {
    }
  }
}
