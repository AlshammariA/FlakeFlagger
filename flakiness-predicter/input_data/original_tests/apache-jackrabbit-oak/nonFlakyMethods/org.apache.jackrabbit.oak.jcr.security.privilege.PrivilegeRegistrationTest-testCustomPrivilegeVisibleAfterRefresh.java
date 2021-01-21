/** 
 * @since oak
 */
@Test public void testCustomPrivilegeVisibleAfterRefresh() throws RepositoryException {
  Session s2=getAdminSession();
  PrivilegeManager pm=getPrivilegeManager(s2);
  try {
    boolean isAbstract=false;
    String privName="testCustomPrivilegeVisibleAfterRefresh";
    privilegeManager.registerPrivilege(privName,isAbstract,new String[0]);
    try {
      Privilege priv=pm.getPrivilege(privName);
      fail("Custom privilege will show up after Session#refresh()");
    }
 catch (    AccessControlException e) {
    }
    s2.refresh(true);
    Privilege priv=pm.getPrivilege(privName);
    assertEquals(privName,priv.getName());
    assertEquals(isAbstract,priv.isAbstract());
    assertFalse(priv.isAggregate());
  }
  finally {
    s2.logout();
  }
}
