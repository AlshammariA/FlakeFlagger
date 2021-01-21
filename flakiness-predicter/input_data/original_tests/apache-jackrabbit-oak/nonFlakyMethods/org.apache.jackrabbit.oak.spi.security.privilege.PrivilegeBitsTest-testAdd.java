@Test public void testAdd(){
  try {
    PrivilegeBits.EMPTY.add(PrivilegeBits.EMPTY);
    fail("UnsupportedOperation expected");
  }
 catch (  UnsupportedOperationException e) {
  }
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  PrivilegeBits mod=PrivilegeBits.getInstance(pb);
  for (int i=0; i < 100; i++) {
    try {
      pb.add(PrivilegeBits.EMPTY);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    try {
      pb.add(mod);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    PrivilegeBits nxt=pb.nextBits();
    try {
      pb.add(nxt);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    long before=getLongValue(mod);
    long nxtLong=getLongValue(nxt);
    mod.add(nxt);
    if (getLongValue(nxt) != 0) {
      assertEquals(before | nxtLong,getLongValue(mod));
    }
    assertTrue(mod.includes(nxt));
    PrivilegeBits tmp=PrivilegeBits.getInstance(pb);
    assertTrue(tmp.includes(pb));
    assertFalse(tmp.includes(nxt));
    if (READ_NODES_PRIVILEGE_BITS.equals(pb)) {
      assertTrue(tmp.includes(PrivilegeBits.BUILT_IN.get(PrivilegeConstants.REP_READ_NODES)));
    }
 else {
      assertFalse(tmp.includes(PrivilegeBits.BUILT_IN.get(PrivilegeConstants.REP_READ_NODES)));
    }
    tmp.add(nxt);
    assertTrue(tmp.includes(pb) && tmp.includes(nxt));
    if (READ_NODES_PRIVILEGE_BITS.equals(pb)) {
      assertTrue(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    }
 else {
      assertFalse(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    }
    tmp.add(READ_NODES_PRIVILEGE_BITS);
    assertTrue(tmp.includes(READ_NODES_PRIVILEGE_BITS));
    pb=nxt;
  }
}
