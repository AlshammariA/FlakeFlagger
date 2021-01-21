/** 
 * @since oak
 */
@Test public void testCustomPrivilegeVisibleToNewSession() throws RepositoryException {
  boolean isAbstract=false;
  String privName="testCustomPrivilegeVisibleToNewSession";
  privilegeManager.registerPrivilege(privName,isAbstract,new String[0]);
  Session s2=getAdminSession();
  try {
    PrivilegeManager pm=getPrivilegeManager(s2);
    Privilege priv=pm.getPrivilege(privName);
    assertEquals(privName,priv.getName());
    assertEquals(isAbstract,priv.isAbstract());
    assertFalse(priv.isAggregate());
  }
  finally {
    s2.logout();
  }
}
