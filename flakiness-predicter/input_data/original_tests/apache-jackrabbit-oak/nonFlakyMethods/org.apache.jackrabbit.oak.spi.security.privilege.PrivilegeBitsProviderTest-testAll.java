@Test public void testAll(){
  PrivilegeBits all=bitsProvider.getBits(JCR_ALL);
  assertFalse(all.isEmpty());
  assertEquals(Collections.singleton(JCR_ALL),bitsProvider.getPrivilegeNames(all));
}
