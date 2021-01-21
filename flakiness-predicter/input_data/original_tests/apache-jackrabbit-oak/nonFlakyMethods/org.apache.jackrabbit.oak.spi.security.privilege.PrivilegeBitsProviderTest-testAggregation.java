@Test public void testAggregation() throws RepositoryException {
  PrivilegeBits writeBits=bitsProvider.getBits(JCR_ADD_CHILD_NODES,JCR_REMOVE_CHILD_NODES,JCR_REMOVE_NODE,JCR_MODIFY_PROPERTIES);
  Set<String> names=bitsProvider.getPrivilegeNames(writeBits);
  assertEquals(1,names.size());
  assertEquals(JCR_WRITE,names.iterator().next());
}
