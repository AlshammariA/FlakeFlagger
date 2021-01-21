@Test public void testIncludes(){
  assertTrue(PrivilegeBits.EMPTY.includes(PrivilegeBits.EMPTY));
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  PrivilegeBits mod=PrivilegeBits.getInstance();
  for (int i=0; i < 100; i++) {
    assertFalse(PrivilegeBits.EMPTY.includes(pb));
    assertTrue(pb.includes(PrivilegeBits.EMPTY));
    mod.add(pb);
    assertTrue(mod.includes(pb));
    PrivilegeBits nxt=pb.nextBits();
    assertTrue(nxt.includes(nxt));
    assertTrue(nxt.includes(PrivilegeBits.getInstance(nxt)));
    assertFalse(pb + " should not include " + nxt,pb.includes(nxt));
    assertFalse(nxt + " should not include " + pb,nxt.includes(pb));
    assertFalse(mod.includes(nxt));
    assertFalse(nxt.includes(mod));
    pb=nxt;
  }
}
