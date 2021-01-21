@Test public void cacheShouldNotBeClearedAfterModelReload() throws IOException {
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  final HttpServletResponse response=Mockito.mock(HttpServletResponse.class,Mockito.RETURNS_DEEP_STUBS);
  Mockito.when(request.getRequestURI()).thenReturn("/app/g3.css");
  final WroConfiguration config=new WroConfiguration();
  config.setDebug(true);
  config.setDisableCache(false);
  Context.set(Context.webContext(request,response,Mockito.mock(FilterConfig.class)));
  final WroManager wroManager=managerFactory.create();
  wroManager.process();
  final CacheStrategy<CacheKey,CacheValue> cacheStrategy=AbstractDecorator.getOriginalDecoratedObject(wroManager.getCacheStrategy());
  Assert.assertNotNull(cacheStrategy.get(new CacheKey("g3",ResourceType.CSS,true)));
  final ReloadModelRunnable reloadModelRunnable=new ReloadModelRunnable(wroManager.getModelFactory());
  reloadModelRunnable.run();
  Assert.assertNotNull(cacheStrategy.get(new CacheKey("g3",ResourceType.CSS,true)));
}
