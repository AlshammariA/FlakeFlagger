@Test public void testUnknownAggregation() throws RepositoryException {
  PrivilegeBits bits=bitsProvider.getBits(REP_WRITE,JCR_LIFECYCLE_MANAGEMENT);
  Set<String> names=bitsProvider.getPrivilegeNames(bits);
  assertEquals(2,names.size());
}
