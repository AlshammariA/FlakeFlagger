/** 
 * OAK-276: potential clash of commit id's after restart.
 */
@Test public void potentialClashOfCommitIds(){
  String headRev=mk.commit("/","+\"a\" : {}",mk.getHeadRevision(),null);
  String branchRev=mk.branch(mk.getHeadRevision());
  mk.dispose();
  mk=new MicroKernelImpl(homeDir.getPath());
  assertEquals("Stored head should be equal",headRev,mk.getHeadRevision());
  headRev=mk.commit("/","+\"b\" : {}",mk.getHeadRevision(),null);
  assertFalse("Commit must not have same id as branch",headRev.equals(branchRev));
}
