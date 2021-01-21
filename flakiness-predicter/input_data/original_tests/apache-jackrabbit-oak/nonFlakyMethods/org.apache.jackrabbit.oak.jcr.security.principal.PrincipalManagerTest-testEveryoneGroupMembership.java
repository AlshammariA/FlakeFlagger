@Test public void testEveryoneGroupMembership(){
  Principal everyone=EveryonePrincipal.getInstance();
  for (PrincipalIterator membership=principalMgr.getGroupMembership(everyone); membership.hasNext(); ) {
    Principal gr=membership.nextPrincipal();
    assertTrue(isGroup(gr));
    if (gr.equals(everyone)) {
      fail("Everyone must never be a member of the EveryOne group.");
    }
  }
}
