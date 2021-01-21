/** 
 * Only provide :id in MK.getNodes()
 */
@Test public void withIdFilter() throws Exception {
  wrapper.filter=PROP_FILTER_WITH_ID;
  int uncachedReads=readTreeWithCleanedCache();
  modifyContent();
  int cachedReads=readTreeWithCache();
  assertTrue("cachedReads: " + cachedReads + " uncachedReads: "+ uncachedReads,cachedReads < uncachedReads);
}
