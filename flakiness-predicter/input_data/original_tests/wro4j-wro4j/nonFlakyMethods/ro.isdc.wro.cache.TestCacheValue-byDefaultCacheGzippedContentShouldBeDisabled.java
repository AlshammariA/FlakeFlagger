@Test public void byDefaultCacheGzippedContentShouldBeDisabled(){
  Assert.assertFalse(Context.get().getConfig().isCacheGzippedContent());
}
