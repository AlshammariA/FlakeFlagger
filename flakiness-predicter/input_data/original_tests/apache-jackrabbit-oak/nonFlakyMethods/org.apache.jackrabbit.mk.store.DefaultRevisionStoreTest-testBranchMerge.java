/** 
 * Verify branch and merge works with garbage collection.
 * @throws Exception if an error occurs
 */
@Test public void testBranchMerge() throws Exception {
  mk.commit("/","+\"a\" : { \"b\":{}, \"c\":{} }",mk.getHeadRevision(),null);
  String branchRevisionId=mk.branch(mk.getHeadRevision());
  mk.commit("/a","+\"d\" : {}",mk.getHeadRevision(),null);
  branchRevisionId=mk.commit("/a","+\"e\" : {}",branchRevisionId,null);
  rs.gc();
  branchRevisionId=mk.commit("/a","+\"f\" : {}",branchRevisionId,null);
  mk.merge(branchRevisionId,null);
  rs.gc();
  String history=mk.getRevisionHistory(Long.MIN_VALUE,Integer.MIN_VALUE,null);
  assertEquals(1,parseJSONArray(history).size());
}
