@Test public void shouldCacheGzippedContentByDefault(){
  Context.get().getConfig().setCacheGzippedContent(true);
  final CacheValue entry=CacheValue.valueOf(RAW_CONTENT,"hash");
  Assert.assertNotNull(null,entry.getGzippedContentInternal());
  Assert.assertNotNull(entry.getGzippedContent());
}
