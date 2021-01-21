@Test public void testIsEmpty(){
  assertTrue(PrivilegeBits.EMPTY.isEmpty());
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  PrivilegeBits mod=PrivilegeBits.getInstance(pb);
  for (int i=0; i < 100; i++) {
    assertFalse(pb.isEmpty());
    assertFalse(PrivilegeBits.getInstance(pb).isEmpty());
    pb=pb.nextBits();
    mod.add(pb);
    assertFalse(mod.isEmpty());
    PrivilegeBits tmp=PrivilegeBits.getInstance(pb);
    tmp.diff(pb);
    assertTrue(tmp.toString(),tmp.isEmpty());
  }
}
