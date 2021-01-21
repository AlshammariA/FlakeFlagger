/** 
 * Provide both :hash and :id
 */
@Test public void withDefaultFilter() throws Exception {
  int uncachedReads=readTreeWithCleanedCache();
  modifyContent();
  int cachedReads=readTreeWithCache();
  assertTrue("cachedReads: " + cachedReads + " uncachedReads: "+ uncachedReads,cachedReads < uncachedReads);
}
