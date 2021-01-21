@Test public void testRemoveAdminNode() throws RepositoryException, NotExecutableException {
  String adminId=admin.getID();
  Node adminNode=superuser.getNode(admin.getPath());
  try {
    adminNode.remove();
    superuser.save();
    fail("Admin user node cannot be removed.");
  }
 catch (  Exception e) {
    superuser.refresh(false);
  }
}
