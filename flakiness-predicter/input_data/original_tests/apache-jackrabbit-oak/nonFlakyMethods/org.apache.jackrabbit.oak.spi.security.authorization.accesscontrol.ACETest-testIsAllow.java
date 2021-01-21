@Test public void testIsAllow() throws RepositoryException {
  ACE ace=createEntry(new String[]{PrivilegeConstants.JCR_READ},true);
  assertTrue(ace.isAllow());
  ace=createEntry(new String[]{PrivilegeConstants.JCR_READ},false);
  assertFalse(ace.isAllow());
}
