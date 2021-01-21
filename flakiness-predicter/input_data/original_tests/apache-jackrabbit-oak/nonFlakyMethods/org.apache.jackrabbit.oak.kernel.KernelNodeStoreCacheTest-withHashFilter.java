/** 
 * Only provide :hash in MK.getNodes()
 */
@Test public void withHashFilter() throws Exception {
  wrapper.filter=PROP_FILTER_WITH_HASH;
  int uncachedReads=readTreeWithCleanedCache();
  modifyContent();
  int cachedReads=readTreeWithCache();
  assertTrue("cachedReads: " + cachedReads + " uncachedReads: "+ uncachedReads,cachedReads < uncachedReads);
}
