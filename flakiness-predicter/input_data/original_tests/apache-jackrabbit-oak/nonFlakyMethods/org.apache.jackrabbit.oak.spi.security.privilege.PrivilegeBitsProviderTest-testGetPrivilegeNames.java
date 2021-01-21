@Test public void testGetPrivilegeNames() throws RepositoryException {
  PrivilegeBits bits=bitsProvider.getBits(JCR_READ_ACCESS_CONTROL);
  Set<String> names=bitsProvider.getPrivilegeNames(bits);
  assertEquals(1,names.size());
  assertEquals(JCR_READ_ACCESS_CONTROL,names.iterator().next());
}
