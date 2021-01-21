@Test public void testAddIsolatedAce() throws Exception {
  String[] ntNames=new String[]{NT_REP_DENY_ACE,NT_REP_GRANT_ACE};
  NodeUtil node=getTestRoot();
  for (  String aceNtName : ntNames) {
    NodeUtil ace=createACE(node,"isolatedACE",aceNtName,testPrincipal.getName(),PrivilegeConstants.JCR_READ);
    try {
      root.commit();
      fail("Writing an isolated ACE should fail.");
    }
 catch (    CommitFailedException e) {
      assertTrue(e.isAccessControlViolation());
    }
 finally {
      ace.getTree().remove();
    }
  }
}
