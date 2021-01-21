@Test public void testDiff(){
  try {
    PrivilegeBits.EMPTY.diff(PrivilegeBits.EMPTY);
    fail("UnsupportedOperation expected");
  }
 catch (  UnsupportedOperationException e) {
  }
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  PrivilegeBits mod=PrivilegeBits.getInstance(pb);
  for (int i=0; i < 100; i++) {
    PrivilegeBits nxt=pb.nextBits();
    try {
      pb.diff(nxt);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    try {
      pb.diff(mod);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    PrivilegeBits before=PrivilegeBits.getInstance(mod);
    mod.diff(nxt);
    assertEquivalent(before,mod);
    mod.add(nxt);
    assertFalse(before.equals(mod));
    mod.diff(nxt);
    assertEquivalent(before,mod);
    mod.add(nxt);
    PrivilegeBits tmp=PrivilegeBits.getInstance(pb);
    tmp.add(nxt);
    tmp.add(READ_NODES_PRIVILEGE_BITS);
    tmp.diff(tmp);
    assertEquivalent(PrivilegeBits.EMPTY,tmp);
    tmp=PrivilegeBits.getInstance(pb);
    tmp.add(nxt);
    tmp.add(READ_NODES_PRIVILEGE_BITS);
    tmp.diff(PrivilegeBits.getInstance(tmp));
    assertEquivalent(PrivilegeBits.EMPTY,tmp);
    tmp=PrivilegeBits.getInstance(pb);
    tmp.diff(nxt);
    assertEquivalent(PrivilegeBits.getInstance(pb),tmp);
    tmp=PrivilegeBits.getInstance(nxt);
    tmp.add(READ_NODES_PRIVILEGE_BITS);
    assertTrue(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    assertTrue(tmp.includes(nxt));
    tmp.diff(nxt);
    assertEquivalent(READ_NODES_PRIVILEGE_BITS,tmp);
    assertTrue(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    assertFalse(tmp.includes(nxt));
    tmp=PrivilegeBits.getInstance(pb);
    tmp.add(READ_NODES_PRIVILEGE_BITS);
    PrivilegeBits tmp2=PrivilegeBits.getInstance(pb);
    tmp2.add(nxt);
    PrivilegeBits tmp3=PrivilegeBits.getInstance(tmp2);
    assertEquivalent(tmp2,tmp3);
    tmp.diff(tmp2);
    if (READ_NODES_PRIVILEGE_BITS.equals(pb)) {
      assertEquivalent(PrivilegeBits.EMPTY,tmp);
    }
 else {
      assertEquivalent(READ_NODES_PRIVILEGE_BITS,tmp);
    }
    assertEquivalent(tmp3,tmp2);
    pb=nxt;
  }
}
