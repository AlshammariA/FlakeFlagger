@Test public void testUnmodifiable(){
  assertSame(PrivilegeBits.EMPTY,PrivilegeBits.EMPTY.unmodifiable());
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  PrivilegeBits mod=PrivilegeBits.getInstance(pb);
  for (int i=0; i < 100; i++) {
    PrivilegeBits nxt=pb.nextBits();
    assertSame(nxt,nxt.unmodifiable());
    assertEquals(nxt,nxt.unmodifiable());
    mod.add(nxt);
    assertNotSame(mod,mod.unmodifiable());
    pb=nxt;
  }
}
