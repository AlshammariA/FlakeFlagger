@Test public void testAggregatePrivileges() throws Exception {
  ACE ace=createEntry(PrivilegeConstants.REP_READ_NODES,PrivilegeConstants.REP_READ_PROPERTIES);
  assertEquals(getBitsProvider().getBits(PrivilegeConstants.JCR_READ),ace.getPrivilegeBits());
  assertArrayEquals(privilegesFromNames(PrivilegeConstants.JCR_READ),ace.getPrivileges());
}
