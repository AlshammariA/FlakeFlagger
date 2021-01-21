/** 
 * @since oak
 */
@Test public void testRegisterPrivilegeWithPendingChanges() throws RepositoryException {
  try {
    session.getRootNode().addNode("test");
    assertTrue(session.hasPendingChanges());
    privilegeManager.registerPrivilege("new",true,new String[0]);
    fail("Privileges may not be registered while there are pending changes.");
  }
 catch (  InvalidItemStateException e) {
  }
 finally {
    superuser.refresh(false);
  }
}
