@Test public void testGetBitsFromInvalidPrivilege(){
  assertEquals(PrivilegeBits.EMPTY,bitsProvider.getBits("invalid1","invalid2"));
}
