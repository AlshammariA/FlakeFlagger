/** 
 * Verify revision history works with garbage collection.
 * @throws Exception if an error occurs
 */
@Test public void testRevisionHistory(){
  mk.commit("/","+\"a\" : { \"c\":{ \"d\":{}  }}",mk.getHeadRevision(),null);
  mk.commit("/","+\"b\" : {}",mk.getHeadRevision(),null);
  mk.commit("/b","+\"e\" : {}",mk.getHeadRevision(),null);
  mk.commit("/a/c","+\"f\" : {}",mk.getHeadRevision(),null);
  String headRevision=mk.getHeadRevision();
  String contents=mk.getNodes("/",headRevision,1,0,-1,null);
  rs.gc();
  assertEquals(headRevision,mk.getHeadRevision());
  assertEquals(contents,mk.getNodes("/",headRevision,1,0,-1,null));
  String history=mk.getRevisionHistory(Long.MIN_VALUE,Integer.MIN_VALUE,null);
  assertEquals(1,parseJSONArray(history).size());
}
