@Test public void testGetBitsFromEmpty(){
  assertEquals(PrivilegeBits.EMPTY,bitsProvider.getBits());
  assertEquals(PrivilegeBits.EMPTY,bitsProvider.getBits(new String[0]));
  assertEquals(PrivilegeBits.EMPTY,bitsProvider.getBits(""));
}
