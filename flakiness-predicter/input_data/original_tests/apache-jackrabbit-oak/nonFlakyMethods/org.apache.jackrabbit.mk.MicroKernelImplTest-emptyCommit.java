@Test public void emptyCommit(){
  String rev=mk.getHeadRevision();
  assertEquals("empty commit must return current head revision",rev,mk.commit("/","",rev,null));
  rev=mk.branch(rev);
  rev=mk.commit("/","+\"x\":{}",rev,null);
  assertEquals("empty branch commit must return current head of branch revision",rev,mk.commit("/","",rev,null));
}
