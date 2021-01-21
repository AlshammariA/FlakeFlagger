@Test public void testChangeNext(){
  try {
    setPrivilegeBits(bitsProvider.getPrivilegesTree(),REP_NEXT,1);
    root.commit();
    fail("Outdated rep:next property must be detected.");
  }
 catch (  CommitFailedException e) {
    assertEquals("OakConstraint0043: Next bits not updated",e.getMessage());
  }
 finally {
    root.refresh();
  }
}
