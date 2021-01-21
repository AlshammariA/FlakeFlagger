@Test public void testOnlyRootIsRepoAccessControllable(){
  NodeUtil testRoot=getTestRoot();
  testRoot.setNames(JcrConstants.JCR_MIXINTYPES,MIX_REP_REPO_ACCESS_CONTROLLABLE);
  try {
    root.commit();
    fail("Only the root node can be made RepoAccessControllable.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
}
