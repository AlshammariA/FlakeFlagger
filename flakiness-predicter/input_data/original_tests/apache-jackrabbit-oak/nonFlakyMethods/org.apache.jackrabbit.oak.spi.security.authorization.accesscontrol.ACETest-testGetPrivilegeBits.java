@Test public void testGetPrivilegeBits() throws RepositoryException {
  ACE entry=createEntry(new String[]{PrivilegeConstants.JCR_READ},true);
  PrivilegeBits bits=entry.getPrivilegeBits();
  assertNotNull(bits);
  assertEquals(bits,getBitsProvider().getBits(PrivilegeConstants.JCR_READ));
  entry=createEntry(new String[]{PrivilegeConstants.REP_WRITE},true);
  bits=entry.getPrivilegeBits();
  assertNotNull(bits);
  assertEquals(bits,getBitsProvider().getBits(PrivilegeConstants.REP_WRITE));
  entry=createEntry(new String[]{PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_REMOVE_CHILD_NODES},true);
  bits=entry.getPrivilegeBits();
  assertNotNull(bits);
  PrivilegeBits expected=getBitsProvider().getBits(PrivilegeConstants.JCR_ADD_CHILD_NODES,PrivilegeConstants.JCR_REMOVE_CHILD_NODES);
  assertEquals(expected,bits);
}
