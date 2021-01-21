@Test public void testEquals2() throws RepositoryException {
  ACE ace=createEntry(PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_READ);
  ACE ace2=createEntry(PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_READ);
  assertEquals(ace,ace2);
}
