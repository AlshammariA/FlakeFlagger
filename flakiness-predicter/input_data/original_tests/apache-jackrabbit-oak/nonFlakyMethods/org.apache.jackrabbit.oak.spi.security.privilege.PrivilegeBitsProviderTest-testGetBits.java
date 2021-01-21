@Test public void testGetBits(){
  PrivilegeBits bits=bitsProvider.getBits(JCR_ADD_CHILD_NODES,JCR_REMOVE_CHILD_NODES);
  assertFalse(bits.isEmpty());
  PrivilegeBits mod=PrivilegeBits.getInstance(bitsProvider.getBits(JCR_ADD_CHILD_NODES)).add(bitsProvider.getBits(JCR_REMOVE_CHILD_NODES));
  assertEquals(bits,mod.unmodifiable());
}
