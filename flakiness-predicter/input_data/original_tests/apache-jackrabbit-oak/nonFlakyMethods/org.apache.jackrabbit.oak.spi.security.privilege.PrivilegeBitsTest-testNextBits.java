@Test public void testNextBits(){
  assertSame(PrivilegeBits.EMPTY,PrivilegeBits.EMPTY.nextBits());
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  long l=getLongValue(pb);
  while (l < Long.MAX_VALUE / 2) {
    l=l << 1;
    pb=pb.nextBits();
    assertEquals(l,getLongValue(pb));
  }
  for (int i=0; i < 10; i++) {
    PrivilegeBits nxt=pb.nextBits();
    assertEquals(nxt,pb.nextBits());
    assertFalse(pb.equals(nxt));
    pb=nxt;
  }
  pb=READ_NODES_PRIVILEGE_BITS;
  for (int i=0; i < 100; i++) {
    PrivilegeBits modifiable=PrivilegeBits.getInstance(pb);
    try {
      modifiable.nextBits();
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    pb=pb.nextBits();
  }
}
