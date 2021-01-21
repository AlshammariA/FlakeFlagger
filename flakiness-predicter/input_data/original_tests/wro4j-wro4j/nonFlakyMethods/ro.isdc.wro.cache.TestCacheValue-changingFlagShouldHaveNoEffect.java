@Test public void changingFlagShouldHaveNoEffect(){
  final WroConfiguration config=Context.get().getConfig();
  config.setCacheGzippedContent(false);
  final CacheValue entry=CacheValue.valueOf(RAW_CONTENT,"hash");
  Assert.assertNull(null,entry.getGzippedContentInternal());
  config.setCacheGzippedContent(true);
  Assert.assertNull(null,entry.getGzippedContentInternal());
  Assert.assertNotNull(entry.getGzippedContent());
}
