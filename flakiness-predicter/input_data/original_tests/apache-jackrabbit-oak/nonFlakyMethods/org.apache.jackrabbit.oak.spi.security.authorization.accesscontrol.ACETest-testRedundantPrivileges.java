@Test public void testRedundantPrivileges() throws Exception {
  ACE ace=createEntry(PrivilegeConstants.JCR_READ,PrivilegeConstants.JCR_READ);
  assertEquals(getBitsProvider().getBits(PrivilegeConstants.JCR_READ),ace.getPrivilegeBits());
}
