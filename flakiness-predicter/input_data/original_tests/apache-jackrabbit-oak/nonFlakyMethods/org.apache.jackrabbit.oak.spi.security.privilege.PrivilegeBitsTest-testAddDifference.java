@Test public void testAddDifference(){
  try {
    PrivilegeBits.EMPTY.addDifference(PrivilegeBits.EMPTY,PrivilegeBits.EMPTY);
    fail("UnsupportedOperation expected");
  }
 catch (  UnsupportedOperationException e) {
  }
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  PrivilegeBits mod=PrivilegeBits.getInstance(pb);
  for (int i=0; i < 100; i++) {
    PrivilegeBits nxt=pb.nextBits();
    try {
      pb.addDifference(nxt,mod);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    try {
      pb.addDifference(nxt,READ_NODES_PRIVILEGE_BITS);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    PrivilegeBits tmp=PrivilegeBits.getInstance(mod);
    tmp.addDifference(nxt,READ_NODES_PRIVILEGE_BITS);
    mod.add(nxt);
    assertEquivalent(mod,tmp);
    if (!pb.equals(READ_NODES_PRIVILEGE_BITS)) {
      tmp=PrivilegeBits.getInstance(nxt);
      PrivilegeBits mod2=PrivilegeBits.getInstance(mod);
      tmp.addDifference(mod2,READ_NODES_PRIVILEGE_BITS);
      assertFalse(nxt.equals(tmp));
      assertEquivalent(mod2,mod);
      assertTrue(tmp.includes(pb));
      assertFalse(tmp.includes(READ_NODES_PRIVILEGE_BITS));
      assertFalse(tmp.includes(mod));
    }
    tmp=PrivilegeBits.getInstance(nxt);
    PrivilegeBits mod2=PrivilegeBits.getInstance(mod);
    tmp.addDifference(READ_NODES_PRIVILEGE_BITS,mod2);
    assertEquivalent(nxt,tmp);
    assertEquivalent(mod2,mod);
    assertFalse(tmp.includes(pb));
    assertFalse(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    assertFalse(tmp.includes(mod));
    tmp=PrivilegeBits.getInstance(nxt);
    tmp.addDifference(READ_NODES_PRIVILEGE_BITS,READ_NODES_PRIVILEGE_BITS);
    assertEquivalent(nxt,tmp);
    assertFalse(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    tmp=PrivilegeBits.getInstance(mod);
    tmp.addDifference(READ_NODES_PRIVILEGE_BITS,READ_NODES_PRIVILEGE_BITS);
    assertEquivalent(mod,tmp);
    assertTrue(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    pb=nxt;
  }
}
