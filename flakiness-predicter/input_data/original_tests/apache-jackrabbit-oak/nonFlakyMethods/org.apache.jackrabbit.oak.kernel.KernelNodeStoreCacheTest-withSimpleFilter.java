/** 
 * Don't provide :hash nor :id. This will not reduce the number of MK.getNodes() after a commit.
 */
@Test public void withSimpleFilter() throws Exception {
  wrapper.filter=PROP_FILTER;
  int uncachedReads=readTreeWithCleanedCache();
  modifyContent();
  int cachedReads=readTreeWithCache();
  assertEquals("cachedReads: " + cachedReads + " uncachedReads: "+ uncachedReads,cachedReads,uncachedReads);
}
