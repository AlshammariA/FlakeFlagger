@Test public void testRedundantAggregation() throws RepositoryException {
  PrivilegeBits writeBits=bitsProvider.getBits(REP_WRITE);
  Set<String> names=bitsProvider.getPrivilegeNames(writeBits);
  assertEquals(1,names.size());
  assertEquals(REP_WRITE,names.iterator().next());
  writeBits=bitsProvider.getBits(REP_WRITE,JCR_WRITE);
  names=bitsProvider.getPrivilegeNames(writeBits);
  assertEquals(1,names.size());
  assertEquals(REP_WRITE,names.iterator().next());
}
