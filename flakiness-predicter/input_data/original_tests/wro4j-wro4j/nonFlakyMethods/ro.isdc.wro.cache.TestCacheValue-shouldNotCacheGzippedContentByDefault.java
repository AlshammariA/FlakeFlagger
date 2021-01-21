@Test public void shouldNotCacheGzippedContentByDefault(){
  final CacheValue entry=CacheValue.valueOf(RAW_CONTENT,"hash");
  Assert.assertEquals(RAW_CONTENT,entry.getRawContent());
  Assert.assertNull(entry.getGzippedContentInternal());
  Assert.assertNotNull(entry.getGzippedContent());
}
